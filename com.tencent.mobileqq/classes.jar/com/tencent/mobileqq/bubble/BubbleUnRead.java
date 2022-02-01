package com.tencent.mobileqq.bubble;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import mqq.app.AppRuntime;

public class BubbleUnRead
{
  private int jdField_a_of_type_Int = 0;
  private Rect jdField_a_of_type_AndroidGraphicsRect = null;
  private final LruCache<String, Bitmap> jdField_a_of_type_AndroidUtilLruCache;
  private final BubbleManager jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager;
  private String jdField_a_of_type_JavaLangString;
  
  BubbleUnRead(BubbleManager paramBubbleManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager = paramBubbleManager;
    this.jdField_a_of_type_AndroidUtilLruCache = new LruCache(10);
  }
  
  public BubbleUnRead.BubbleUnreadBundle a(TextView paramTextView, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a;
    if (localObject2 == null) {
      return null;
    }
    Object localObject1 = null;
    BubbleInfo localBubbleInfo = BubbleUtils.a(paramInt1, (AppRuntime)localObject2, null, null);
    if (localBubbleInfo.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      localObject1 = localBubbleInfo.jdField_a_of_type_ArrayOfJavaLangString;
      if ((localObject1 == null) || (!a())) {
        break label594;
      }
      if (paramInt2 >= 10) {
        break label89;
      }
      localObject1 = localObject1[0];
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label113;
      }
      return null;
      if (paramInt1 <= 0) {
        break;
      }
      localObject1 = a(paramInt1);
      break;
      label89:
      if (paramInt2 < 100) {
        localObject1 = localObject1[1];
      } else {
        localObject1 = localObject1[2];
      }
    }
    label113:
    Object localObject3 = (Bitmap)this.jdField_a_of_type_AndroidUtilLruCache.get(localObject1);
    if ((localObject3 != null) || (FileUtils.a((String)localObject1)))
    {
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = BitmapFactory.decodeFile((String)localObject1);
        if (localObject2 != null) {
          this.jdField_a_of_type_AndroidUtilLruCache.put(localObject1, localObject2);
        }
      }
      else if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && (TextUtils.equals(paramString, this.jdField_a_of_type_JavaLangString))) {}
      label589:
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_AndroidGraphicsRect == null)
          {
            this.jdField_a_of_type_JavaLangString = paramString;
            this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
            paramString = paramTextView.getText();
            localObject1 = new Rect(paramTextView.getPaddingLeft(), paramTextView.getPaddingTop(), paramTextView.getPaddingRight(), paramTextView.getPaddingBottom());
            localObject3 = paramTextView.getBackground();
            paramTextView.setText("1");
            paramTextView.measure(0, 0);
            int n = paramTextView.getMeasuredWidth();
            if (Build.VERSION.SDK_INT >= 16) {
              paramTextView.setBackground(new BitmapDrawable((Bitmap)localObject2));
            }
            paramTextView.setPadding(0, 0, 0, 0);
            paramTextView.measure(0, 0);
            paramInt2 = paramTextView.getMeasuredWidth();
            paramInt1 = paramTextView.getMeasuredHeight();
            int i = Math.max((n - paramInt2) / 2, 0);
            int k = Math.max((n - paramInt1) / 2, 0);
            int j = Math.max(n - paramInt2 - i, 0);
            int m = Math.max(n - paramInt1 - k, 0);
            paramTextView.setPadding(j, m, i, k);
            paramTextView.measure(0, 0);
            int i1 = n - paramTextView.getMeasuredWidth();
            paramInt2 = j;
            paramInt1 = i;
            if (i1 != 0)
            {
              paramInt2 = j + i1 / 2;
              paramInt1 = i + (i1 - i1 / 2);
            }
            n -= paramTextView.getMeasuredHeight();
            j = m;
            i = k;
            if (n != 0)
            {
              j = m + n / 2;
              i = k + (n - n / 2);
            }
            this.jdField_a_of_type_AndroidGraphicsRect.set(paramInt2, j, paramInt1, i);
            paramTextView.setText(paramString);
            if (Build.VERSION.SDK_INT >= 16)
            {
              paramTextView.setBackground((Drawable)localObject3);
              paramTextView.setPadding(((Rect)localObject1).left, ((Rect)localObject1).top, ((Rect)localObject1).right, ((Rect)localObject1).bottom);
            }
          }
          else
          {
            paramTextView = new BitmapDrawable((Bitmap)localObject2);
            if (localBubbleInfo.jdField_a_of_type_Int <= 0) {
              break label589;
            }
            paramInt1 = localBubbleInfo.b;
            return new BubbleUnRead.BubbleUnreadBundle(paramTextView, paramInt1, this.jdField_a_of_type_AndroidGraphicsRect);
            QLog.d("BubbleManager", 2, "find no bubble unread : decode error");
            return null;
          }
          paramTextView.setBackgroundDrawable((Drawable)localObject3);
          continue;
          paramInt1 = -1;
        }
        finally {}
      }
    }
    label594:
    QLog.d("BubbleManager", 2, "find no bubble unread");
    return null;
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a;
    if (localObject == null) {
      return;
    }
    if (!b()) {
      paramBoolean = true;
    }
    int i;
    SharedPreferences.Editor localEditor;
    if (paramBoolean != a())
    {
      if (!paramBoolean) {
        break label136;
      }
      i = 1;
      this.jdField_a_of_type_Int = i;
      localEditor = ((AppInterface)localObject).getApp().getSharedPreferences(((AppInterface)localObject).getCurrentAccountUin(), 0).edit();
      if (i != 1) {
        break label141;
      }
    }
    for (;;)
    {
      localEditor.putBoolean("svip_bubble_unread_switch", bool).apply();
      localObject = (VipInfoHandler)((AppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
      if (localObject != null) {
        ((VipInfoHandler)localObject).a(paramBoolean);
      }
      QLog.d("BubbleManager", 2, "setBubbleUnreadShow " + paramBoolean);
      return;
      label136:
      i = -1;
      break;
      label141:
      bool = false;
    }
  }
  
  public boolean a()
  {
    boolean bool = true;
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a;
    if (localAppInterface == null) {
      return false;
    }
    int i;
    if (this.jdField_a_of_type_Int == 0)
    {
      if (localAppInterface.getApp().getSharedPreferences(localAppInterface.getCurrentAccountUin(), 0).getBoolean("svip_bubble_unread_switch", true))
      {
        i = 1;
        this.jdField_a_of_type_Int = i;
      }
    }
    else
    {
      QLog.d("BubbleManager", 2, "showBubbleUnread " + this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Int != 1) {
        break label97;
      }
    }
    for (;;)
    {
      return bool;
      i = -1;
      break;
      label97:
      bool = false;
    }
  }
  
  String[] a(int paramInt)
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramInt).getAbsolutePath() + File.separatorChar + "unread" + File.separatorChar + "unread1.png";
    String str2 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramInt).getAbsolutePath() + File.separatorChar + "unread" + File.separatorChar + "unread2.png";
    String str3 = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramInt).getAbsolutePath() + File.separatorChar + "unread" + File.separatorChar + "unread3.png";
    if ((new File(str1).exists()) && (new File(str2).exists()) && (new File(str3).exists())) {
      return new String[] { str1, str2, str3 };
    }
    return null;
  }
  
  public boolean b()
  {
    return QzoneConfig.getInstance().getConfig("K_QQ_VAS", "SK_QQ_VAS_ShowSwitchPersonalUnread", 0) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleUnRead
 * JD-Core Version:    0.7.0.1
 */