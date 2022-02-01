package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.shopping.ShoppingFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.QQLiveJumpUtil;
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
  
  private void c()
  {
    String str2 = (String)this.f.get("title");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = IliveDbManager.getILiveEnterInfo(1);
    }
    ShoppingFragment.a(this.b, str1);
  }
  
  private void d()
  {
    if (QQLiveJumpUtil.f())
    {
      if ((this.b instanceof Activity))
      {
        DialogUtil.a(this.b, 230, null, "你正在直播中，暂时无法进入其他直播间", null, "知道了", new IliveJumpAction.1(this), null).show();
        return;
      }
      QQToast.makeText(this.b, 4, "你正在直播中，暂时无法进入其他直播间", 0).show();
      return;
    }
    String str8 = (String)this.f.get("roomid");
    String str9 = (String)this.f.get("rtmp");
    Object localObject1 = (String)this.f.get("source");
    String str11 = (String)this.f.get("retain");
    String str10 = (String)this.f.get("closejump");
    String str1 = (String)this.f.get("trace_info");
    String str2 = (String)this.f.get("noclearTop");
    String str3 = (String)this.f.get("recom_info");
    String str4 = (String)this.f.get("room_type");
    String str5 = (String)this.f.get("game_id");
    String str6 = (String)this.f.get("game_tag_id");
    String str7 = (String)this.f.get("video_source");
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("roomType:");
      ((StringBuilder)localObject2).append(str4);
      ((StringBuilder)localObject2).append(", gameId:");
      ((StringBuilder)localObject2).append(str5);
      ((StringBuilder)localObject2).append(", gameTagId:");
      ((StringBuilder)localObject2).append(str6);
      ((StringBuilder)localObject2).append(", videoSource:");
      ((StringBuilder)localObject2).append(str7);
      QLog.d("IliveJumpAction", 2, ((StringBuilder)localObject2).toString());
    }
    int i;
    try
    {
      localObject2 = (String)this.f.get("from");
      if (localObject2 == null) {
        i = 99;
      } else {
        i = Integer.parseInt((String)localObject2);
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
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = "scheme";
    }
    boolean bool;
    try
    {
      if (!TextUtils.isEmpty(str11))
      {
        int j = Integer.parseInt(str11);
        if (j == 1) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      bool = false;
    }
    localObject1 = new IliveJumpParams(this.b, (String)localObject1, str8, str9, bool, null, str10, i);
    if ((!TextUtils.isEmpty(str2)) && (str2.equals("1"))) {
      ((IliveJumpParams)localObject1).k = true;
    } else {
      ((IliveJumpParams)localObject1).k = false;
    }
    ((IliveJumpParams)localObject1).l = str3;
    ((IliveJumpParams)localObject1).j = str1;
    ((IliveJumpParams)localObject1).m = str4;
    ((IliveJumpParams)localObject1).o = str6;
    ((IliveJumpParams)localObject1).n = str5;
    ((IliveJumpParams)localObject1).p = str7;
    IliveEntranceUtil.a((IliveJumpParams)localObject1);
  }
  
  public boolean a()
  {
    try
    {
      if ("watch".equals(this.e))
      {
        d();
        return true;
      }
      if ("mqqapi://vaslive/myshopping".equals(this.e)) {
        c();
      }
      return true;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("IliveJumpAction", 1, localStringBuilder.toString());
      h_("IliveJumpAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.IliveJumpAction
 * JD-Core Version:    0.7.0.1
 */