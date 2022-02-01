package com.qq.taf.jce.dynamic;

import java.util.Arrays;
import java.util.Comparator;

public class StructField
  extends JceField
{
  private static final Comparator<JceField> tagComp = new StructField.1();
  private JceField[] data;
  
  StructField(JceField[] paramArrayOfJceField, int paramInt)
  {
    super(paramInt);
    this.data = paramArrayOfJceField;
  }
  
  public JceField[] get()
  {
    return this.data;
  }
  
  public JceField getFieldByTag(int paramInt)
  {
    paramInt = Arrays.binarySearch(this.data, JceField.createZero(paramInt), tagComp);
    if (paramInt >= 0) {
      return this.data[paramInt];
    }
    return null;
  }
  
  public boolean setByTag(int paramInt, JceField paramJceField)
  {
    paramInt = Arrays.binarySearch(this.data, JceField.createZero(paramInt), tagComp);
    if (paramInt >= 0)
    {
      this.data[paramInt] = paramJceField;
      return true;
    }
    int i = -paramInt - 1;
    JceField[] arrayOfJceField = new JceField[this.data.length + 1];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfJceField[paramInt] = this.data[paramInt];
      paramInt += 1;
    }
    arrayOfJceField[i] = paramJceField;
    for (paramInt = i;; paramInt = i)
    {
      paramJceField = this.data;
      if (paramInt >= paramJceField.length) {
        break;
      }
      i = paramInt + 1;
      arrayOfJceField[i] = paramJceField[paramInt];
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.StructField
 * JD-Core Version:    0.7.0.1
 */