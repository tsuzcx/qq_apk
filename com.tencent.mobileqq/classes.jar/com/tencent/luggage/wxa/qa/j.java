package com.tencent.luggage.wxa.qa;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;

public class j
  extends e
{
  public j(String paramString, d paramd, h paramh)
  {
    super(paramString, paramd, paramh);
  }
  
  public void a()
  {
    if ((this.b.getFileSystem() != null) && (this.a != null))
    {
      f.a.c(new j.1(this));
      return;
    }
    this.c.a("Failed to load icon via temp file", this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qa.j
 * JD-Core Version:    0.7.0.1
 */