package com.android.dx.dex.code;

import com.android.dx.rop.code.LocalItem;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;

public class LocalList$Entry
  implements Comparable<Entry>
{
  private final int address;
  private final LocalList.Disposition disposition;
  private final RegisterSpec spec;
  private final CstType type;
  
  public LocalList$Entry(int paramInt, LocalList.Disposition paramDisposition, RegisterSpec paramRegisterSpec)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("address < 0");
    }
    if (paramDisposition == null) {
      throw new NullPointerException("disposition == null");
    }
    try
    {
      if (paramRegisterSpec.getLocalItem() == null) {
        throw new NullPointerException("spec.getLocalItem() == null");
      }
    }
    catch (NullPointerException paramDisposition)
    {
      throw new NullPointerException("spec == null");
    }
    this.address = paramInt;
    this.disposition = paramDisposition;
    this.spec = paramRegisterSpec;
    this.type = CstType.intern(paramRegisterSpec.getType());
  }
  
  public int compareTo(Entry paramEntry)
  {
    int j = 1;
    int i;
    if (this.address < paramEntry.address) {
      i = -1;
    }
    boolean bool;
    do
    {
      do
      {
        return i;
        i = j;
      } while (this.address > paramEntry.address);
      bool = isStart();
      if (bool == paramEntry.isStart()) {
        break;
      }
      i = j;
    } while (bool);
    return -1;
    return this.spec.compareTo(paramEntry.spec);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Entry)) {}
    while (compareTo((Entry)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public int getAddress()
  {
    return this.address;
  }
  
  public LocalList.Disposition getDisposition()
  {
    return this.disposition;
  }
  
  public CstString getName()
  {
    return this.spec.getLocalItem().getName();
  }
  
  public int getRegister()
  {
    return this.spec.getReg();
  }
  
  public RegisterSpec getRegisterSpec()
  {
    return this.spec;
  }
  
  public CstString getSignature()
  {
    return this.spec.getLocalItem().getSignature();
  }
  
  public CstType getType()
  {
    return this.type;
  }
  
  public boolean isStart()
  {
    return this.disposition == LocalList.Disposition.START;
  }
  
  public boolean matches(Entry paramEntry)
  {
    return matches(paramEntry.spec);
  }
  
  public boolean matches(RegisterSpec paramRegisterSpec)
  {
    return this.spec.equalsUsingSimpleType(paramRegisterSpec);
  }
  
  public String toString()
  {
    return Integer.toHexString(this.address) + " " + this.disposition + " " + this.spec;
  }
  
  public Entry withDisposition(LocalList.Disposition paramDisposition)
  {
    if (paramDisposition == this.disposition) {
      return this;
    }
    return new Entry(this.address, paramDisposition, this.spec);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.dex.code.LocalList.Entry
 * JD-Core Version:    0.7.0.1
 */