package com.tencent.mobileqq.app.parser;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class JumpParserFactory
{
  public static JumpParserBase a(JumpParserResult paramJumpParserResult, ArrayList<JumpParserBean> paramArrayList)
  {
    if ((paramJumpParserResult != null) && (paramArrayList != null)) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramJumpParserResult.d() != null) {
          break label134;
        }
        QLog.e("JumpParserFactory", 1, "createJumpParser error: param is null");
        return null;
      }
      catch (Exception paramJumpParserResult)
      {
        JumpParserBean localJumpParserBean;
        QLog.e("JumpParserFactory", 1, "createJumpParser error: " + paramJumpParserResult.getMessage());
        return null;
      }
      if (i < paramArrayList.size())
      {
        localJumpParserBean = (JumpParserBean)paramArrayList.get(i);
        if (!paramJumpParserResult.d().startsWith(localJumpParserBean.a())) {
          break label141;
        }
        paramJumpParserResult = localJumpParserBean.a();
        if (paramJumpParserResult != null)
        {
          paramJumpParserResult = paramJumpParserResult.newInstance();
          if ((paramJumpParserResult instanceof JumpParserBase)) {
            paramJumpParserResult = (JumpParserBase)paramJumpParserResult;
          } else {
            QLog.e("JumpParserFactory", 1, "createJumpParser error: not extends JumpParserBase");
          }
        }
        else
        {
          paramJumpParserResult = null;
        }
      }
      else
      {
        paramJumpParserResult = null;
        continue;
        label134:
        i = 0;
        continue;
      }
      return paramJumpParserResult;
      label141:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.JumpParserFactory
 * JD-Core Version:    0.7.0.1
 */