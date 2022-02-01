package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.shopping.ShoppingFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.entity.IliveJumpParams;
import cooperation.ilive.manager.IliveDbManager;
import cooperation.ilive.util.IliveEntranceUtil;
import java.util.HashMap;

public class IliveJumpAction
  extends JumpActionBase
{
  public IliveJumpAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private void a()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = IliveDbManager.getILiveEnterInfo(1);
    }
    ShoppingFragment.a(this.jdField_a_of_type_AndroidContentContext, str1);
  }
  
  private void e()
  {
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomid");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("rtmp");
    localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source");
    String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("retain");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("closejump");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("trace_info");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("noclearTop");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("recom_info");
    for (;;)
    {
      try
      {
        str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
        if (str8 != null) {
          continue;
        }
        i = 99;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        String str8;
        localNumberFormatException.printStackTrace();
        QLog.e("IliveJumpAction", 1, "print exception: " + localNumberFormatException.getMessage());
        int i = 99;
        continue;
        bool = false;
        continue;
        continue;
      }
      QLog.d("IliveJumpAction", 1, "scheme parsed from:" + i);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        continue;
      }
      localObject = "scheme";
      try
      {
        if (TextUtils.isEmpty(str7)) {
          continue;
        }
        int j = Integer.parseInt(str7);
        if (j != 1) {
          continue;
        }
        bool = true;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        boolean bool = false;
        continue;
        ((IliveJumpParams)localObject).b = false;
        continue;
        bool = false;
        continue;
      }
      localObject = new IliveJumpParams(this.jdField_a_of_type_AndroidContentContext, (String)localObject, str4, str5, bool, null, str6, i);
      if ((TextUtils.isEmpty(str2)) || (!str2.equals("1"))) {
        continue;
      }
      ((IliveJumpParams)localObject).b = true;
      ((IliveJumpParams)localObject).g = str3;
      ((IliveJumpParams)localObject).f = str1;
      IliveEntranceUtil.a((IliveJumpParams)localObject);
      return;
      i = Integer.parseInt(str8);
    }
  }
  
  public boolean a()
  {
    boolean bool = true;
    try
    {
      if ("watch".equals(this.c))
      {
        e();
        return true;
      }
      if ("mqqapi://vaslive/myshopping".equals(this.c))
      {
        a();
        return true;
      }
    }
    catch (Exception localException)
    {
      QLog.e("IliveJumpAction", 1, "doAction error: " + localException.getMessage());
      a("IliveJumpAction");
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.IliveJumpAction
 * JD-Core Version:    0.7.0.1
 */