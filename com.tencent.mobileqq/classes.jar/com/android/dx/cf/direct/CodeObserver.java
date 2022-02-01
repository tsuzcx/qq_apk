package com.android.dx.cf.direct;

import com.android.dx.cf.code.ByteOps;
import com.android.dx.cf.code.BytecodeArray.Visitor;
import com.android.dx.cf.code.SwitchList;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstDouble;
import com.android.dx.rop.cst.CstFloat;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstKnownNull;
import com.android.dx.rop.cst.CstLong;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import java.util.ArrayList;

public class CodeObserver
  implements BytecodeArray.Visitor
{
  private final ByteArray bytes;
  private final ParseObserver observer;
  
  public CodeObserver(ByteArray paramByteArray, ParseObserver paramParseObserver)
  {
    if (paramByteArray == null) {
      throw new NullPointerException("bytes == null");
    }
    if (paramParseObserver == null) {
      throw new NullPointerException("observer == null");
    }
    this.bytes = paramByteArray;
    this.observer = paramParseObserver;
  }
  
  private String header(int paramInt)
  {
    int i = this.bytes.getUnsignedByte(paramInt);
    String str2 = ByteOps.opName(i);
    String str1 = str2;
    if (i == 196)
    {
      i = this.bytes.getUnsignedByte(paramInt + 1);
      str1 = str2 + " " + ByteOps.opName(i);
    }
    return Hex.u2(paramInt) + ": " + str1;
  }
  
  private void visitLiteralDouble(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (paramInt3 != 1) {}
    for (String str = " #" + Hex.u8(paramLong);; str = "")
    {
      this.observer.parsed(this.bytes, paramInt2, paramInt3, header(paramInt2) + str + " // " + Double.longBitsToDouble(paramLong));
      return;
    }
  }
  
  private void visitLiteralFloat(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt3 != 1) {}
    for (String str = " #" + Hex.u4(paramInt4);; str = "")
    {
      this.observer.parsed(this.bytes, paramInt2, paramInt3, header(paramInt2) + str + " // " + Float.intBitsToFloat(paramInt4));
      return;
    }
  }
  
  private void visitLiteralInt(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str2;
    String str1;
    if (paramInt3 == 1)
    {
      str2 = " // ";
      paramInt1 = this.bytes.getUnsignedByte(paramInt2);
      if ((paramInt3 != 1) && (paramInt1 != 16)) {
        break label105;
      }
      str1 = "#" + Hex.s1(paramInt4);
    }
    for (;;)
    {
      this.observer.parsed(this.bytes, paramInt2, paramInt3, header(paramInt2) + str2 + str1);
      return;
      str2 = " ";
      break;
      label105:
      if (paramInt1 == 17) {
        str1 = "#" + Hex.s2(paramInt4);
      } else {
        str1 = "#" + Hex.s4(paramInt4);
      }
    }
  }
  
  private void visitLiteralLong(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    String str1;
    if (paramInt3 == 1)
    {
      str1 = " // ";
      if (paramInt3 != 1) {
        break label73;
      }
    }
    label73:
    for (String str2 = Hex.s1((int)paramLong);; str2 = Hex.s8(paramLong))
    {
      this.observer.parsed(this.bytes, paramInt2, paramInt3, header(paramInt2) + str1 + str2);
      return;
      str1 = " #";
      break;
    }
  }
  
  public int getPreviousOffset()
  {
    return -1;
  }
  
  public void setPreviousOffset(int paramInt) {}
  
  public void visitBranch(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt3 <= 3) {}
    for (String str = Hex.u2(paramInt4);; str = Hex.u4(paramInt4))
    {
      this.observer.parsed(this.bytes, paramInt2, paramInt3, header(paramInt2) + " " + str);
      return;
    }
  }
  
  public void visitConstant(int paramInt1, int paramInt2, int paramInt3, Constant paramConstant, int paramInt4)
  {
    if ((paramConstant instanceof CstKnownNull))
    {
      visitNoArgs(paramInt1, paramInt2, paramInt3, null);
      return;
    }
    if ((paramConstant instanceof CstInteger))
    {
      visitLiteralInt(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    if ((paramConstant instanceof CstLong))
    {
      visitLiteralLong(paramInt1, paramInt2, paramInt3, ((CstLong)paramConstant).getValue());
      return;
    }
    if ((paramConstant instanceof CstFloat))
    {
      visitLiteralFloat(paramInt1, paramInt2, paramInt3, ((CstFloat)paramConstant).getIntBits());
      return;
    }
    if ((paramConstant instanceof CstDouble))
    {
      visitLiteralDouble(paramInt1, paramInt2, paramInt3, ((CstDouble)paramConstant).getLongBits());
      return;
    }
    String str = "";
    if (paramInt4 != 0) {
      if (paramInt1 != 197) {
        break label197;
      }
    }
    label197:
    for (str = ", " + Hex.u1(paramInt4);; str = ", " + Hex.u2(paramInt4))
    {
      this.observer.parsed(this.bytes, paramInt2, paramInt3, header(paramInt2) + " " + paramConstant + str);
      return;
    }
  }
  
  public void visitInvalid(int paramInt1, int paramInt2, int paramInt3)
  {
    this.observer.parsed(this.bytes, paramInt2, paramInt3, header(paramInt2));
  }
  
  public void visitLocal(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Type paramType, int paramInt5)
  {
    int i = 1;
    String str1;
    label24:
    String str2;
    Object localObject;
    label61:
    label103:
    ParseObserver localParseObserver;
    ByteArray localByteArray;
    StringBuilder localStringBuilder;
    if (paramInt3 <= 3)
    {
      str1 = Hex.u1(paramInt4);
      if (paramInt3 != 1) {
        break label205;
      }
      paramInt4 = i;
      str2 = "";
      if (paramInt1 == 132)
      {
        localObject = new StringBuilder().append(", #");
        if (paramInt3 > 3) {
          break label211;
        }
        str2 = Hex.s1(paramInt5);
        str2 = str2;
      }
      localObject = "";
      if (paramType.isCategory2())
      {
        localObject = new StringBuilder();
        if (paramInt4 == 0) {
          break label221;
        }
        paramType = ",";
        localObject = paramType + " category-2";
      }
      localParseObserver = this.observer;
      localByteArray = this.bytes;
      localStringBuilder = new StringBuilder().append(header(paramInt2));
      if (paramInt4 == 0) {
        break label228;
      }
    }
    label205:
    label211:
    label221:
    label228:
    for (paramType = " // ";; paramType = " ")
    {
      localParseObserver.parsed(localByteArray, paramInt2, paramInt3, paramType + str1 + str2 + (String)localObject);
      return;
      str1 = Hex.u2(paramInt4);
      break;
      paramInt4 = 0;
      break label24;
      str2 = Hex.s2(paramInt5);
      break label61;
      paramType = " //";
      break label103;
    }
  }
  
  public void visitNewarray(int paramInt1, int paramInt2, CstType paramCstType, ArrayList<Constant> paramArrayList)
  {
    if (paramInt2 == 1) {}
    for (paramArrayList = " // ";; paramArrayList = " ")
    {
      paramCstType = paramCstType.getClassType().getComponentType().toHuman();
      this.observer.parsed(this.bytes, paramInt1, paramInt2, header(paramInt1) + paramArrayList + paramCstType);
      return;
    }
  }
  
  public void visitNoArgs(int paramInt1, int paramInt2, int paramInt3, Type paramType)
  {
    this.observer.parsed(this.bytes, paramInt2, paramInt3, header(paramInt2));
  }
  
  public void visitSwitch(int paramInt1, int paramInt2, int paramInt3, SwitchList paramSwitchList, int paramInt4)
  {
    int i = paramSwitchList.size();
    StringBuffer localStringBuffer = new StringBuffer(i * 20 + 100);
    localStringBuffer.append(header(paramInt2));
    if (paramInt4 != 0) {
      localStringBuffer.append(" // padding: " + Hex.u4(paramInt4));
    }
    localStringBuffer.append('\n');
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      localStringBuffer.append("  ");
      localStringBuffer.append(Hex.s4(paramSwitchList.getValue(paramInt1)));
      localStringBuffer.append(": ");
      localStringBuffer.append(Hex.u2(paramSwitchList.getTarget(paramInt1)));
      localStringBuffer.append('\n');
      paramInt1 += 1;
    }
    localStringBuffer.append("  default: ");
    localStringBuffer.append(Hex.u2(paramSwitchList.getDefaultTarget()));
    this.observer.parsed(this.bytes, paramInt2, paramInt3, localStringBuffer.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.direct.CodeObserver
 * JD-Core Version:    0.7.0.1
 */