package com.android.dx.io.instructions;

import com.android.dex.DexException;
import com.android.dx.util.Hex;

 enum InstructionCodec$34
{
  InstructionCodec$34()
  {
    super(str, i, null);
  }
  
  public DecodedInstruction decode(int paramInt, CodeInput paramCodeInput)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    int m = paramCodeInput.read();
    int n = paramCodeInput.readInt();
    switch (m)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new DexException("bogus element_width: " + Hex.u2(m));
    case 1: 
      localObject = new byte[n];
      i = 0;
      m = 0;
      j = 1;
      if (m < n)
      {
        k = i;
        if (j != 0) {
          k = paramCodeInput.read();
        }
        localObject[m] = ((byte)(k & 0xFF));
        m += 1;
        if (j == 0) {}
        for (i = 1;; i = 0)
        {
          j = i;
          i = k >> 8;
          break;
        }
      }
      return new FillArrayDataPayloadDecodedInstruction(this, paramInt, (byte[])localObject);
    case 2: 
      localObject = new short[n];
      while (i < n)
      {
        localObject[i] = ((short)paramCodeInput.read());
        i += 1;
      }
      return new FillArrayDataPayloadDecodedInstruction(this, paramInt, (short[])localObject);
    case 4: 
      localObject = new int[n];
      i = j;
      while (i < n)
      {
        localObject[i] = paramCodeInput.readInt();
        i += 1;
      }
      return new FillArrayDataPayloadDecodedInstruction(this, paramInt, (int[])localObject);
    }
    Object localObject = new long[n];
    i = k;
    while (i < n)
    {
      localObject[i] = paramCodeInput.readLong();
      i += 1;
    }
    return new FillArrayDataPayloadDecodedInstruction(this, paramInt, (long[])localObject);
  }
  
  public void encode(DecodedInstruction paramDecodedInstruction, CodeOutput paramCodeOutput)
  {
    paramDecodedInstruction = (FillArrayDataPayloadDecodedInstruction)paramDecodedInstruction;
    short s = paramDecodedInstruction.getElementWidthUnit();
    Object localObject = paramDecodedInstruction.getData();
    paramCodeOutput.write(paramDecodedInstruction.getOpcodeUnit());
    paramCodeOutput.write(s);
    paramCodeOutput.writeInt(paramDecodedInstruction.getSize());
    switch (s)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new DexException("bogus element_width: " + Hex.u2(s));
    case 1: 
      paramCodeOutput.write((byte[])localObject);
      return;
    case 2: 
      paramCodeOutput.write((short[])localObject);
      return;
    case 4: 
      paramCodeOutput.write((int[])localObject);
      return;
    }
    paramCodeOutput.write((long[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.io.instructions.InstructionCodec.34
 * JD-Core Version:    0.7.0.1
 */