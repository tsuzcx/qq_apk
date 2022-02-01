package com.tencent.luggage.wxa.oz;

import com.tencent.luggage.wxa.rb.a.a;
import com.tencent.luggage.wxa.rb.d;

public abstract class b<_Model extends com.tencent.luggage.wxa.rb.a,  extends a>
  extends d<_Model>
{
  public b(com.tencent.luggage.wxa.rb.b paramb, a.a parama, String paramString, String[] paramArrayOfString)
  {
    super(paramb, parama, paramString, paramArrayOfString);
  }
  
  public boolean a(_Model param_Model, boolean paramBoolean)
  {
    super.a(param_Model, paramBoolean);
    return a(param_Model, new String[0]);
  }
  
  public boolean a(_Model param_Model, boolean paramBoolean, String... paramVarArgs)
  {
    String[] arrayOfString;
    if (paramVarArgs != null)
    {
      arrayOfString = paramVarArgs;
      if (paramVarArgs.length != 0) {}
    }
    else
    {
      arrayOfString = ((a)param_Model).t_();
    }
    return super.a(param_Model, paramBoolean, arrayOfString);
  }
  
  public boolean a(_Model param_Model, String... paramVarArgs)
  {
    String[] arrayOfString;
    if (paramVarArgs != null)
    {
      arrayOfString = paramVarArgs;
      if (paramVarArgs.length != 0) {}
    }
    else
    {
      arrayOfString = ((a)param_Model).t_();
    }
    return super.a(param_Model, arrayOfString);
  }
  
  public boolean b(_Model param_Model, boolean paramBoolean, String... paramVarArgs)
  {
    String[] arrayOfString;
    if (paramVarArgs != null)
    {
      arrayOfString = paramVarArgs;
      if (paramVarArgs.length != 0) {}
    }
    else
    {
      arrayOfString = ((a)param_Model).t_();
    }
    return super.b(param_Model, paramBoolean, arrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oz.b
 * JD-Core Version:    0.7.0.1
 */