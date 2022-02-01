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
      try
      {
        if (paramJumpParserResult.e() == null)
        {
          continue;
          if (i >= paramArrayList.size()) {
            break label148;
          }
          JumpParserBean localJumpParserBean = (JumpParserBean)paramArrayList.get(i);
          if (!paramJumpParserResult.e().startsWith(localJumpParserBean.a())) {
            break label141;
          }
          paramJumpParserResult = localJumpParserBean.b();
          if (paramJumpParserResult == null) {
            break;
          }
          paramJumpParserResult = paramJumpParserResult.newInstance();
          if ((paramJumpParserResult instanceof JumpParserBase)) {
            return (JumpParserBase)paramJumpParserResult;
          }
          QLog.e("JumpParserFactory", 1, "createJumpParser error: not extends JumpParserBase");
          break;
          QLog.e("JumpParserFactory", 1, "createJumpParser error: param is null");
          return null;
        }
      }
      catch (Exception paramJumpParserResult)
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("createJumpParser error: ");
        paramArrayList.append(paramJumpParserResult.getMessage());
        QLog.e("JumpParserFactory", 1, paramArrayList.toString());
        return null;
      }
      int i = 0;
      continue;
      label141:
      i += 1;
      continue;
      label148:
      paramJumpParserResult = null;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.JumpParserFactory
 * JD-Core Version:    0.7.0.1
 */