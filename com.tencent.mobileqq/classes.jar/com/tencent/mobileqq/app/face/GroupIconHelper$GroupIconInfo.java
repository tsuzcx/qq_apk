package com.tencent.mobileqq.app.face;

import java.util.ArrayList;

class GroupIconHelper$GroupIconInfo
{
  public boolean a;
  public byte b = 1;
  public boolean c;
  public long d;
  public String e;
  public int f;
  public int g;
  public String h;
  public ArrayList<String> i = new ArrayList();
  public boolean j = false;
  public boolean k = false;
  public boolean l = false;
  
  private GroupIconHelper$GroupIconInfo(GroupIconHelper paramGroupIconHelper) {}
  
  public void a(byte paramByte)
  {
    if (paramByte == 3)
    {
      this.a = false;
      this.b = 1;
      this.c = false;
      this.e = null;
      this.f = 0;
      this.g = 0;
      this.h = null;
      this.i.clear();
      this.j = false;
      this.k = false;
      this.l = false;
      return;
    }
    if (paramByte == 2)
    {
      this.c = false;
      this.l = true;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nGroupIconInfo");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("isChanged:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("state:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("isSyncFace:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("startTime:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("faceUinSet:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("faceCount:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("crateIconCount:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("lastCreatedFaceUinSet:");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("isPstnIcon:");
    localStringBuilder.append(this.j);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("hasRealPstnUser:");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\n |-");
    localStringBuilder.append("isFromCreate:");
    localStringBuilder.append(this.l);
    try
    {
      localStringBuilder.append("\n |-");
      localStringBuilder.append("memberFaceList:");
      localStringBuilder.append(this.i);
      label291:
      return localStringBuilder.toString();
    }
    catch (Exception localException)
    {
      break label291;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.GroupIconHelper.GroupIconInfo
 * JD-Core Version:    0.7.0.1
 */