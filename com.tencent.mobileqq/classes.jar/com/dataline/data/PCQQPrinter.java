package com.dataline.data;

import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class PCQQPrinter
  extends PrinterEntity
{
  public boolean a(List paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((paramList != null) && (paramList.size() > 0) && (paramString != null))
    {
      ((DataLineHandler)paramQQAppInterface.a(8)).a((ArrayList)paramList, "printer", paramString.getBytes(), Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.dataline.data.PCQQPrinter
 * JD-Core Version:    0.7.0.1
 */