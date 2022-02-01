package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class ActivateFriendView
  extends LinearLayout
  implements DecodeTaskCompletionListener
{
  private static final int jdField_a_of_type_Int = ViewUtils.b(85.0F);
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private static final int jdField_b_of_type_Int = ViewUtils.b(70.0F);
  private static final int jdField_c_of_type_Int = ViewUtils.b(70.0F);
  private static final int d = ViewUtils.b(52.0F);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ActivateFriendView.1(this);
  private ActivateFriendGrid.GridCallBack jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$GridCallBack = null;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ActivateFriendView.2(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ActivateFriendsManager jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager;
  ActivateFriendsObserver jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver = new ActivateFriendView.3(this);
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private ArrayList<ActivateFriendItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_a_of_type_Boolean = true;
  private ArrayList<ActivateFriendViewItem> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private boolean jdField_c_of_type_Boolean = true;
  private int e = 0;
  
  public ActivateFriendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Bitmap a(String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 1, true, (byte)0);
    }
    return jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public ActivateFriendViewItem a(int paramInt)
  {
    ActivateFriendViewItem localActivateFriendViewItem = new ActivateFriendViewItem(getContext(), this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
    addView(localActivateFriendViewItem, new LinearLayout.LayoutParams(paramInt, -2));
    return localActivateFriendViewItem;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
    {
      if (paramBitmap != null) {
        this.jdField_a_of_type_JavaUtilHashtable.put(paramString, paramBitmap);
      }
      if (paramInt1 <= 0)
      {
        paramInt2 = this.jdField_b_of_type_JavaUtilArrayList.size();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          long l = ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).uin;
          paramString = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(String.valueOf(l));
          if (paramString != null) {
            ((ActivateFriendViewItem)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt1)).setHead(paramString);
          }
          paramInt1 += 1;
        }
        this.jdField_a_of_type_JavaUtilHashtable.clear();
      }
    }
  }
  
  public void setCheckAbilityEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setData(QQAppInterface paramQQAppInterface, ArrayList<ActivateFriendItem> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (jdField_a_of_type_AndroidGraphicsBitmap == null) {
      jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.f();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    paramQQAppInterface = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (paramQQAppInterface.hasNext()) {
      removeView((ActivateFriendViewItem)paramQQAppInterface.next());
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver);
    this.e = 0;
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = -2;
    if (k != 2)
    {
      if (k != 3)
      {
        if (k != 4)
        {
          if (k == 5) {
            i = d;
          }
        }
        else {
          i = jdField_c_of_type_Int;
        }
      }
      else {
        i = jdField_b_of_type_Int;
      }
    }
    else {
      i = jdField_a_of_type_Int;
    }
    int j = 0;
    while (j < k)
    {
      paramQQAppInterface = a(i);
      paramQQAppInterface.setBirthday(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).birthdayDesc);
      paramArrayList = String.valueOf(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).uin);
      if (!TextUtils.isEmpty(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).nickName)) {
        paramQQAppInterface.setNickName(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).nickName);
      } else {
        paramQQAppInterface.setNickName(ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList, true));
      }
      paramQQAppInterface.setHead(a(paramArrayList));
      if (this.jdField_a_of_type_Boolean) {
        paramQQAppInterface.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      if (this.jdField_a_of_type_Boolean) {
        if ((!getResources().getString(2131689549).equals(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).birthdayDesc)) && (!this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.c(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).uin, ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).type)))
        {
          if ((!this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).uin, ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).type)) && (!this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.b(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).uin, ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).type)))
          {
            this.e += 1;
            paramQQAppInterface.setChecked(true);
          }
          else
          {
            paramQQAppInterface.setChecked(false);
            paramQQAppInterface.setBirthday(getResources().getString(2131689552));
          }
        }
        else
        {
          paramQQAppInterface.setChecked(false);
          paramQQAppInterface.setBirthday(getResources().getString(2131689549));
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList.add(paramQQAppInterface);
      j += 1;
    }
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$GridCallBack;
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this.e);
    }
  }
  
  public void setGridCallBack(ActivateFriendGrid.GridCallBack paramGridCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$GridCallBack = paramGridCallBack;
  }
  
  public void setSkinable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setTextScrolling(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendView
 * JD-Core Version:    0.7.0.1
 */