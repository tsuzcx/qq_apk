package com.tencent.mobileqq.activity.activateFriend;

import agbv;
import agbx;
import agby;
import agbz;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import anyu;
import aold;
import aole;
import aoof;
import aoog;
import bhlg;
import bhmq;
import bhtq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ActivateFriendItem;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class ActivateFriendView
  extends LinearLayout
  implements aoog
{
  private static final int jdField_a_of_type_Int = bhtq.b(85.0F);
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private static final int jdField_b_of_type_Int = bhtq.b(70.0F);
  private static final int jdField_c_of_type_Int = bhtq.b(70.0F);
  private static final int d = bhtq.b(52.0F);
  private agbv jdField_a_of_type_Agbv;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new agbx(this);
  anyu jdField_a_of_type_Anyu = new agby(this);
  public aold a;
  aole jdField_a_of_type_Aole = new agbz(this);
  private aoof jdField_a_of_type_Aoof;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
    Bitmap localBitmap = this.jdField_a_of_type_Aoof.a(1, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Aoof.a()) {
      this.jdField_a_of_type_Aoof.a(paramString, 1, true, (byte)0);
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
    if (!this.jdField_a_of_type_Aoof.a())
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
      jdField_a_of_type_AndroidGraphicsBitmap = bhmq.a();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    paramQQAppInterface = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (paramQQAppInterface.hasNext()) {
      removeView((ActivateFriendViewItem)paramQQAppInterface.next());
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    if (this.jdField_a_of_type_Aoof == null)
    {
      this.jdField_a_of_type_Aoof = new aoof(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Aoof.a(this);
    }
    this.jdField_a_of_type_Aold = ((aold)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(85));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Aole);
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
          if ((!getResources().getString(2131689517).equals(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).birthdayDesc)) && (!this.jdField_a_of_type_Aold.c(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).uin, ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).type))) {
            break label472;
          }
          paramQQAppInterface.setChecked(false);
          paramQQAppInterface.setBirthday(getResources().getString(2131689517));
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
      paramQQAppInterface.setNickName(bhlg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList, true));
      break label289;
      label472:
      if ((this.jdField_a_of_type_Aold.a(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).uin, ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).type)) || (this.jdField_a_of_type_Aold.b(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).uin, ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).type)))
      {
        paramQQAppInterface.setChecked(false);
        paramQQAppInterface.setBirthday(getResources().getString(2131689520));
      }
      else
      {
        this.e += 1;
        paramQQAppInterface.setChecked(true);
      }
    }
    label592:
    if (this.jdField_a_of_type_Agbv != null) {
      this.jdField_a_of_type_Agbv.a(this.e);
    }
  }
  
  public void setGridCallBack(agbv paramagbv)
  {
    this.jdField_a_of_type_Agbv = paramagbv;
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