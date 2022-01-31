package com.tencent.mobileqq.avatar.dynamicavatar;

import abkl;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VasManager;
import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class VasFaceManager
  extends VasManager
{
  private static Bundle jdField_a_of_type_AndroidOsBundle;
  public static Handler a;
  public static Boolean a;
  private static final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static boolean jdField_a_of_type_Boolean;
  public QQAppInterface a;
  private final LongSparseArray jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray();
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public VasFaceManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
  }
  
  public static int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    int j = 0;
    paramString = paramQQAppInterface.a(paramString, false);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.faceId > 0) {
        i = 4;
      }
    }
    return i;
  }
  
  public static Bundle a()
  {
    if (jdField_a_of_type_AndroidOsBundle == null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_loop", 3);
      localBundle.putBoolean("key_double_bitmap", true);
      localBundle.putBoolean("key_draw_round", true);
      localBundle.putBoolean("key_get_reset_loop", false);
      localBundle.putBoolean("key_stop_on_first", true);
      localBundle.putIntArray("key_tagId_arr", new int[] { 9, 10, 2, 1, 0, 11 });
      localBundle.putString("key_name", "-face-");
      jdField_a_of_type_AndroidOsBundle = localBundle;
    }
    return jdField_a_of_type_AndroidOsBundle;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    String str;
    StringBuilder localStringBuilder;
    switch (paramInt2)
    {
    default: 
      str = "small.png";
      localStringBuilder = new StringBuilder();
      if (a()) {
        localStringBuilder.append(AppConstants.bp);
      }
      break;
    }
    for (;;)
    {
      localStringBuilder.append(paramInt1).append(File.separatorChar).append(str);
      return localStringBuilder.toString();
      str = "large.png";
      break;
      str = "medium.png";
      break;
      localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_st/");
    }
  }
  
  public static String a(long paramLong)
  {
    return "-face-" + Long.toString(paramLong);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String[] arrayOfString;
    do
    {
      return null;
      arrayOfString = paramString.split("\\.");
    } while (arrayOfString.length != 3);
    for (;;)
    {
      int i;
      try
      {
        int j = Integer.parseInt(arrayOfString[1]);
        if ("small".equals(arrayOfString[2]))
        {
          i = 100;
          return a(j, i);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e("Q.qqhead.VasFaceManager", 1, "getFacePath failed from " + paramString, localNumberFormatException);
        return null;
      }
      if ("medium".equals(localNumberFormatException[2]))
      {
        i = 200;
      }
      else
      {
        if (!"large".equals(localNumberFormatException[2])) {
          break;
        }
        i = 640;
      }
    }
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean) {}
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      int i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
      while (i >= 0)
      {
        ((VasFaceManager.Replayer)jdField_a_of_type_JavaUtilArrayList.get(i)).a();
        i -= 1;
      }
      jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public static void a(ApngDrawable paramApngDrawable)
  {
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i >= 0)
        {
          VasFaceManager.Replayer localReplayer = (VasFaceManager.Replayer)jdField_a_of_type_JavaUtilArrayList.get(i);
          ApngImage localApngImage = (ApngImage)localReplayer.b.get();
          if (localApngImage == null) {
            jdField_a_of_type_JavaUtilArrayList.remove(i);
          } else if (localApngImage == paramApngDrawable.getImage()) {
            localReplayer.c();
          }
        }
        else
        {
          return;
        }
      }
      i -= 1;
    }
  }
  
  public static void a(ApngDrawable paramApngDrawable, DynamicAvatarView paramDynamicAvatarView)
  {
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i >= 0)
        {
          VasFaceManager.Replayer localReplayer = (VasFaceManager.Replayer)jdField_a_of_type_JavaUtilArrayList.get(i);
          ApngImage localApngImage = (ApngImage)localReplayer.b.get();
          if (localApngImage == null) {
            jdField_a_of_type_JavaUtilArrayList.remove(i);
          } else if (localApngImage == paramApngDrawable.getImage()) {
            localReplayer.a = new WeakReference(paramDynamicAvatarView);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.qqhead.VasFaceManager", 2, "registerNewFace: " + paramApngDrawable.getImage() + " " + "");
          }
          jdField_a_of_type_JavaUtilArrayList.add(new VasFaceManager.Replayer(paramDynamicAvatarView, paramApngDrawable, jdField_a_of_type_AndroidOsHandler));
          return;
        }
      }
      i -= 1;
    }
  }
  
  private void a(ChatMessage paramChatMessage)
  {
    Object localObject;
    if (paramChatMessage.isSend())
    {
      localObject = paramChatMessage.selfuin;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label66;
      }
    }
    for (;;)
    {
      return;
      if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
      {
        localObject = paramChatMessage.frienduin;
        break;
      }
      localObject = paramChatMessage.senderuin;
      break;
      label66:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject, false);
      if ((localObject != null) && (((ExtensionInfo)localObject).faceIdUpdateTime != 0L) && (((ExtensionInfo)localObject).faceId != 0) && (VasApngUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        localObject = a(((ExtensionInfo)localObject).faceId, 100);
        try
        {
          paramChatMessage = new URL("vasapngdownloader", (String)localObject, a(paramChatMessage.uniseq));
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mUseApngImage = true;
          localURLDrawableOptions.mUseMemoryCache = false;
          paramChatMessage = URLDrawable.getDrawable(paramChatMessage, localURLDrawableOptions).getCurrDrawable();
          if ((paramChatMessage instanceof ApngDrawable))
          {
            a((ApngDrawable)paramChatMessage);
            return;
          }
        }
        catch (Exception paramChatMessage)
        {
          QLog.e("Q.qqhead.VasFaceManager", 1, "getApngDrawable ApngImage err, path:" + (String)localObject, paramChatMessage);
        }
      }
    }
  }
  
  private static boolean a()
  {
    if (jdField_a_of_type_JavaLangBoolean == null) {
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(SystemUtil.a());
    }
    return jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  private boolean a(ListView paramListView, int paramInt1, int paramInt2)
  {
    if (!(paramListView.getChildAt(paramInt1) instanceof BaseChatItemLayout)) {}
    DynamicAvatarView localDynamicAvatarView;
    do
    {
      do
      {
        return false;
        paramListView = (BaseChatItemLayout)paramListView.getChildAt(paramInt1);
      } while (paramListView == null);
      localDynamicAvatarView = paramListView.a;
    } while (localDynamicAvatarView == null);
    if (paramListView.getTop() + localDynamicAvatarView.getBottom() > paramInt2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.VasFaceManager", 2, "resume: " + jdField_a_of_type_JavaUtilArrayList.size());
    }
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i >= 0)
        {
          VasFaceManager.Replayer localReplayer = (VasFaceManager.Replayer)jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((ApngImage)localReplayer.b.get() != null) {
            localReplayer.b();
          } else {
            jdField_a_of_type_JavaUtilArrayList.remove(i);
          }
        }
      }
      jdField_a_of_type_Boolean = false;
      return;
      i -= 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, VasManager.CompleteListener paramCompleteListener, Object paramObject)
  {
    String str;
    switch (paramInt2)
    {
    default: 
      str = ".small";
    }
    for (;;)
    {
      str = "face." + paramInt1 + str;
      b(str, paramCompleteListener, paramObject);
      ThreadManager.post(new abkl(this, a(paramInt1, paramInt2), str), 5, null, true);
      return;
      str = ".large";
      continue;
      str = ".medium";
    }
  }
  
  public void a(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo != null) && (!TextUtils.isEmpty(paramExtensionInfo.uin)))
    {
      QLog.d("Q.qqhead.VasFaceManager", 1, "onFaceIdChanged uin: " + paramExtensionInfo.uin + " newId: " + paramExtensionInfo.faceId + " faceUpdateTime: " + paramExtensionInfo.faceIdUpdateTime);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(46, true, new Object[] { paramExtensionInfo.uin });
      a(paramExtensionInfo.uin, null);
      if (paramExtensionInfo.uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
        localEditor.putInt("my_store_face_id", paramExtensionInfo.faceId);
        localEditor.commit();
      }
    }
  }
  
  public void a(ListView paramListView, ChatAdapter1 paramChatAdapter1, int paramInt)
  {
    int j = 0;
    int k = paramListView.getContext().getResources().getDimensionPixelSize(2131558448);
    int n = paramListView.getFirstVisiblePosition();
    int m = paramListView.getChildCount();
    int i1 = paramListView.getHeaderViewsCount();
    if (n < i1) {}
    ChatMessage localChatMessage;
    for (int i = 0;; i = n - i1)
    {
      m = Math.min(paramChatAdapter1.getCount(), m + n - i1);
      if (n < i1) {
        j = i1 - n;
      }
      if (paramInt != 0) {
        break label174;
      }
      while (i < m)
      {
        if (a(paramListView, j, k))
        {
          localChatMessage = (ChatMessage)paramChatAdapter1.getItem(i);
          if (localChatMessage != null)
          {
            long l = localChatMessage.uniseq;
            if (this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(l) == null) {
              a(localChatMessage);
            }
          }
        }
        j += 1;
        i += 1;
      }
    }
    this.jdField_a_of_type_ComTencentUtilLongSparseArray.a();
    for (;;)
    {
      return;
      label174:
      if (this.jdField_a_of_type_ComTencentUtilLongSparseArray.a() == 0) {
        while (i < m)
        {
          if (a(paramListView, j, k))
          {
            localChatMessage = (ChatMessage)paramChatAdapter1.getItem(i);
            if (localChatMessage != null) {
              this.jdField_a_of_type_ComTencentUtilLongSparseArray.a(localChatMessage.uniseq, this);
            }
          }
          j += 1;
          i += 1;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.d("Q.qqhead.VasFaceManager", 1, "download store face scid: " + paramString + " errorCode: " + paramInt);
    if ((paramInt <= 0) || (paramInt == 0)) {}
    for (String str = a(paramString);; str = null)
    {
      a(paramString, str);
      return;
    }
  }
  
  public void a(String paramString, VasManager.CompleteListener paramCompleteListener, Object paramObject)
  {
    QLog.d("Q.qqhead.VasFaceManager", 1, "requestFaceId uin: " + paramString);
    b(paramString, paramCompleteListener, paramObject);
    AvatarPendantUtil.a(paramString);
    AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(Collection paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      a((ExtensionInfo)paramCollection.next());
    }
  }
  
  public boolean a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return new File(paramString).exists();
    }
    return false;
  }
  
  public void b(String paramString, int paramInt)
  {
    try
    {
      ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, true);
      if (localExtensionInfo == null)
      {
        localExtensionInfo = new ExtensionInfo();
        localExtensionInfo.uin = paramString;
      }
      for (int i = 0;; i = localExtensionInfo.faceId)
      {
        QLog.d("Q.qqhead.VasFaceManager", 1, "handleFaceId uin: " + paramString + " oldId: " + i + " newId: " + paramInt);
        paramString = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        localExtensionInfo.setStatus(1000);
        localExtensionInfo.faceId = paramInt;
        localExtensionInfo.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
        localExtensionInfo.timestamp = System.currentTimeMillis();
        paramString.a(localExtensionInfo);
        a(localExtensionInfo);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "", paramString);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager
 * JD-Core Version:    0.7.0.1
 */