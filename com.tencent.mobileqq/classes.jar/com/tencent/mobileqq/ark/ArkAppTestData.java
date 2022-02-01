package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ArkAppTestData
  extends Entity
{
  public long date;
  @unique
  public String name;
  public String value;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppTestData
 * JD-Core Version:    0.7.0.1
 */