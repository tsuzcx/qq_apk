package com.tencent.mobileqq.activity.activateFriend;

import afma;
import afmc;
import afmd;
import afme;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import anvi;
import aohe;
import aohf;
import bheg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class ActivateFriendView
  extends LinearLayout
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private static final int jdField_a_of_type_Int = ViewUtils.dpToPx(85.0F);
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private static final int jdField_b_of_type_Int = ViewUtils.dpToPx(70.0F);
  private static final int jdField_c_of_type_Int = ViewUtils.dpToPx(70.0F);
  private static final int d = ViewUtils.dpToPx(52.0F);
  private afma jdField_a_of_type_Afma;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afmc(this);
  anvi jdField_a_of_type_Anvi = new afmd(this);
  public aohe a;
  aohf jdField_a_of_type_Aohf = new afme(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private ArrayList<ActivateFriendItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_a_of_type_Boolean = true;
  private ArrayList<ActivateFriendViewItem> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean = true;
  private int e;
  
  public ActivateFriendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Bitmap a(String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, 1, true, (byte)0);
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
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
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
      jdField_a_of_type_AndroidGraphicsBitmap = bheg.a();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    paramQQAppInterface = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (paramQQAppInterface.hasNext()) {
      removeView((ActivateFriendViewItem)paramQQAppInterface.next());
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    }
    this.jdField_a_of_type_Aohe = ((aohe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Aohf);
    this.e = 0;
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i;
    int j;
    switch (k)
    {
    default: 
      i = -2;
      j = 0;
      label198:
      if (j >= k) {
        break label592;
      }
      paramQQAppInterface = a(i);
      paramQQAppInterface.setBirthday(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).birthdayDesc);
      paramArrayList = String.valueOf(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).uin);
      if (!TextUtils.isEmpty(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).nickName))
      {
        paramQQAppInterface.setNickName(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).nickName);
        label289:
        paramQQAppInterface.setHead(a(paramArrayList));
        if (this.jdField_a_of_type_Boolean) {
          paramQQAppInterface.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          if ((!getResources().getString(2131689516).equals(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).birthdayDesc)) && (!this.jdField_a_of_type_Aohe.c(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).uin, ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).type))) {
            break label472;
          }
          paramQQAppInterface.setChecked(false);
          paramQQAppInterface.setBirthday(getResources().getString(2131689516));
        }
      }
      break;
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramQQAppInterface);
      j += 1;
      break label198;
      i = jdField_a_of_type_Int;
      break;
      i = jdField_b_of_type_Int;
      break;
      i = jdField_c_of_type_Int;
      break;
      i = d;
      break;
      paramQQAppInterface.setNickName(ContactUtils.getBuddyName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList, true));
      break label289;
      label472:
      if ((this.jdField_a_of_type_Aohe.a(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).uin, ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).type)) || (this.jdField_a_of_type_Aohe.b(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).uin, ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).type)))
      {
        paramQQAppInterface.setChecked(false);
        paramQQAppInterface.setBirthday(getResources().getString(2131689519));
      }
      else
      {
        this.e += 1;
        paramQQAppInterface.setChecked(true);
      }
    }
    label592:
    if (this.jdField_a_of_type_Afma != null) {
      this.jdField_a_of_type_Afma.a(this.e);
    }
  }
  
  public void setGridCallBack(afma paramafma)
  {
    this.jdField_a_of_type_Afma = paramafma;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendView
 * JD-Core Version:    0.7.0.1
 */