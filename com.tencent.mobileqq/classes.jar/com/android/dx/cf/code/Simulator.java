package com.android.dx.cf.code;

import com.android.dx.rop.type.Type;

public class Simulator
{
  private static final String LOCAL_MISMATCH_ERROR = "This is symptomatic of .class transformation tools that ignore local variable information.";
  private final BytecodeArray code;
  private final LocalVariableList localVariables;
  private final Machine machine;
  private final Simulator.SimVisitor visitor;
  
  public Simulator(Machine paramMachine, ConcreteMethod paramConcreteMethod)
  {
    if (paramMachine == null) {
      throw new NullPointerException("machine == null");
    }
    if (paramConcreteMethod == null) {
      throw new NullPointerException("method == null");
    }
    this.machine = paramMachine;
    this.code = paramConcreteMethod.getCode();
    this.localVariables = paramConcreteMethod.getLocalVariables();
    this.visitor = new Simulator.SimVisitor(this);
  }
  
  private static SimException illegalTos()
  {
    return new SimException("stack mismatch: illegal top-of-stack for opcode");
  }
  
  private static Type requiredArrayTypeFor(Type paramType1, Type paramType2)
  {
    if (paramType2 == Type.KNOWN_NULL)
    {
      if (paramType1.isReference()) {
        return Type.KNOWN_NULL;
      }
      return paramType1.getArrayType();
    }
    if ((paramType1 == Type.OBJECT) && (paramType2.isArray()) && (paramType2.getComponentType().isReference())) {
      return paramType2;
    }
    if ((paramType1 == Type.BYTE) && (paramType2 == Type.BOOLEAN_ARRAY)) {
      return Type.BOOLEAN_ARRAY;
    }
    return paramType1.getArrayType();
  }
  
  public int simulate(int paramInt, Frame paramFrame)
  {
    this.visitor.setFrame(paramFrame);
    return this.code.parseInstruction(paramInt, this.visitor);
  }
  
  public void simulate(ByteBlock paramByteBlock, Frame paramFrame)
  {
    int j = paramByteBlock.getEnd();
    this.visitor.setFrame(paramFrame);
    try
    {
      int i = paramByteBlock.getStart();
      while (i < j)
      {
        int k = this.code.parseInstruction(i, this.visitor);
        this.visitor.setPreviousOffset(i);
        i += k;
      }
      return;
    }
    catch (SimException paramByteBlock)
    {
      paramFrame.annotate(paramByteBlock);
      throw paramByteBlock;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.code.Simulator
 * JD-Core Version:    0.7.0.1
 */