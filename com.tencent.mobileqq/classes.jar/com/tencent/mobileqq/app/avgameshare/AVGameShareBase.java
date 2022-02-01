package com.tencent.mobileqq.app.avgameshare;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.sharehelper.IShareBusinessInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class AVGameShareBase
  implements IShareBusinessInterface
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  protected ShareActionSheet a;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public AVGameShareBase(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Int = paramInt;
    paramString1 = new ShareActionSheetV2.Param();
    paramString1.context = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create(paramString1);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public String a()
  {
    return this.b;
  }
  
  protected String a(int paramInt)
  {
    return "";
  }
  
  public String a(long paramLong)
  {
    String str = String.valueOf(paramLong);
    Object localObject = str;
    if (!TextUtils.isEmpty(str))
    {
      localObject = str;
      if (str.length() < 9)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("000000000".substring(0, 9 - str.length()));
        ((StringBuilder)localObject).append(str);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem> a()
  {
    QLog.d("AVGameShareBase", 1, "getPathsLines");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    return localArrayList;
  }
  
  protected void a()
  {
    try
    {
      Object localObject1 = GameEngine.a().a();
      long l = ((EngineData)localObject1).a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("copyRoomId: ");
      ((StringBuilder)localObject2).append(l);
      QLog.d("AVGameShareBase", 1, ((StringBuilder)localObject2).toString());
      int i = ((EngineData)localObject1).d();
      ReportController.b(null, "dc00898", "", "", "0X800B066", "0X800B066", i, 0, "5", String.valueOf(l), "", "");
      ReportController.b(null, "dc00898", "", "", "0X800B067", "0X800B067", i, 0, "", String.valueOf(l), "", "");
      localObject2 = GameEngine.a().a().getCurrentAccountUin();
      localObject2 = ((EngineData)localObject1).a().getNick((String)localObject2);
      localObject1 = (ClipboardManager)BaseApplicationImpl.getContext().getSystemService("clipboard");
      localObject2 = ClipData.newPlainText("avgame_share_copy_room_id_label", String.format(a().getString(2131690304), new Object[] { localObject2, a(), a(l) }));
      ClipboardMonitor.setPrimaryClip((ClipboardManager)localObject1, (ClipData)localObject2);
      ((ClipboardManager)localObject1).setPrimaryClip((ClipData)localObject2);
      AVGameHandler.a().b().post(new AVGameShareBase.1(this));
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("copyRoomId error: ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.e("AVGameShareBase", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  protected abstract void a(int paramInt);
  
  protected void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    int i = paramActionSheetItem.action;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleClickMenuItem action: ");
    localStringBuilder.append(i);
    QLog.d("AVGameShareBase", 1, localStringBuilder.toString());
    if (i != 2) {
      if (i != 3)
      {
        if ((i != 9) && (i != 10))
        {
          if (i != 72)
          {
            if (i != 73)
            {
              if (i != 160)
              {
                paramActionSheetItem = new StringBuilder();
                paramActionSheetItem.append("handleClickMenuItem not support action: ");
                paramActionSheetItem.append(i);
                QLog.e("AVGameShareBase", 1, paramActionSheetItem.toString());
                break label145;
              }
              a();
              break label145;
            }
          }
          else
          {
            b(paramActionSheetItem);
            break label145;
          }
        }
        else
        {
          a(i);
          break label145;
        }
      }
      else
      {
        d();
        break label145;
      }
    }
    c();
    label145:
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected int b()
  {
    return 10000;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected String b(int paramInt)
  {
    return "";
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem> b()
  {
    QLog.d("AVGameShareBase", 1, "getOperationsLines");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(160));
    return localArrayList;
  }
  
  public abstract void b();
  
  public void b(int paramInt) {}
  
  protected abstract void b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem);
  
  protected boolean b()
  {
    return false;
  }
  
  public String c()
  {
    return this.c;
  }
  
  protected abstract void c();
  
  public void c(int paramInt) {}
  
  protected String d()
  {
    return "";
  }
  
  protected abstract void d();
  
  public void d(int paramInt) {}
  
  protected String e()
  {
    return "";
  }
  
  public void e(int paramInt) {}
  
  protected String f()
  {
    return "https://qqvgame.qq.com/0e7d77945e6e86568d67a788d8c6874a.png";
  }
  
  public void f(int paramInt) {}
  
  protected String g()
  {
    return "https://qqvgame.qq.com/b4feec84dbadde0df6eb60ea0437aad1.png";
  }
  
  public void g(int paramInt) {}
  
  public void h(int paramInt) {}
  
  public void i(int paramInt) {}
  
  public void j(int paramInt) {}
  
  public void k(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareBase
 * JD-Core Version:    0.7.0.1
 */