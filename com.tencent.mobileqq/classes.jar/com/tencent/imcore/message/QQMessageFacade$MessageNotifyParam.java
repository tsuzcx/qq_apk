package com.tencent.imcore.message;

public class QQMessageFacade$MessageNotifyParam
{
  public static final int OPERATION_DELETE = 0;
  public Object obj;
  public int operation;
  public int type;
  public String uin;
  
  public QQMessageFacade$MessageNotifyParam() {}
  
  public QQMessageFacade$MessageNotifyParam(String paramString, int paramInt1, int paramInt2, Object paramObject)
  {
    this.uin = paramString;
    this.type = paramInt1;
    this.operation = paramInt2;
    this.obj = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade.MessageNotifyParam
 * JD-Core Version:    0.7.0.1
 */