package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.shopping.ShoppingFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.entity.IliveJumpParams;
import cooperation.ilive.manager.IliveDbManager;
import cooperation.ilive.util.IliveEntranceUtil;
import java.util.HashMap;

public class IliveJumpAction
  extends JumpAction
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
  
  private void b()
  {
    String str4 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("roomid");
    String str5 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("rtmp");
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("source");
    String str7 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("retain");
    String str6 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("closejump");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("trace_info");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("noclearTop");
    String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("recom_info");
    int i = 99;
    try
    {
      String str8 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("from");
      if (str8 != null) {
        i = Integer.parseInt(str8);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("print exception: ");
      localStringBuilder2.append(localNumberFormatException.getMessage());
      QLog.e("IliveJumpAction", 1, localStringBuilder2.toString());
      i = 99;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("scheme parsed from:");
    localStringBuilder1.append(i);
    QLog.d("IliveJumpAction", 1, localStringBuilder1.toString());
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = "scheme";
    }
    boolean bool;
    try
    {
      if (!TextUtils.isEmpty(str7))
      {
        int j = Integer.parseInt(str7);
        if (j == 1)
        {
          bool = true;
          break label271;
        }
      }
      bool = false;
    }
    catch (Throwable localThrowable)
    {
      label271:
      localThrowable.printStackTrace();
      bool = false;
    }
    localObject = new IliveJumpParams(this.jdField_a_of_type_AndroidContentContext, (String)localObject, str4, str5, bool, null, str6, i);
    if ((!TextUtils.isEmpty(str2)) && (str2.equals("1"))) {
      ((IliveJumpParams)localObject).b = true;
    } else {
      ((IliveJumpParams)localObject).b = false;
    }
    ((IliveJumpParams)localObject).g = str3;
    ((IliveJumpParams)localObject).f = str1;
    IliveEntranceUtil.a((IliveJumpParams)localObject);
  }
  
  public boolean a()
  {
    try
    {
      if ("watch".equals(this.c))
      {
        b();
        return true;
      }
      if ("mqqapi://vaslive/myshopping".equals(this.c)) {
        a();
      }
      return true;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("IliveJumpAction", 1, localStringBuilder.toString());
      b_("IliveJumpAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.IliveJumpAction
 * JD-Core Version:    0.7.0.1
 */