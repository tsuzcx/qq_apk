package com.tencent.mobileqq.activity.activateFriend;

import aenc;
import aend;
import aene;
import aenf;
import aeng;
import altm;
import amga;
import amgd;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import bdaq;
import bdbb;
import bdbc;
import bdgc;
import bdhj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class ActivateFriendGrid
  extends FrameLayout
  implements bdbc
{
  private static int jdField_a_of_type_Int = 15;
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private static int jdField_b_of_type_Int = 14;
  private aenf jdField_a_of_type_Aenf;
  private aeng jdField_a_of_type_Aeng;
  altm jdField_a_of_type_Altm = new aend(this);
  public amga a;
  amgd jdField_a_of_type_Amgd = new aene(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aenc(this);
  private bdbb jdField_a_of_type_Bdbb;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<ActivateFriendItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_a_of_type_Boolean = true;
  private ArrayList<ActivateFriendGridItem> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private int d;
  private int e;
  
  public ActivateFriendGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt)
  {
    paramInt = 0;
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
      paramInt = ((ActivateFriendGridItem)this.jdField_b_of_type_JavaUtilArrayList.get(0)).getMeasuredHeight();
    }
    return paramInt * 2 + bdaq.a(getContext(), jdField_a_of_type_Int) * 1;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 3) {
      return paramInt2;
    }
    if (paramInt1 < 3) {
      return 3;
    }
    return paramInt2 - 3;
  }
  
  private Bitmap a(String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Bdbb.a(1, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Bdbb.a()) {
      this.jdField_a_of_type_Bdbb.a(paramString, 1, true, (byte)0);
    }
    return jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public ActivateFriendGridItem a()
  {
    ActivateFriendGridItem localActivateFriendGridItem = new ActivateFriendGridItem(getContext(), this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
    addView(localActivateFriendGridItem, new FrameLayout.LayoutParams(-2, -2));
    return localActivateFriendGridItem;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdbb != null)
    {
      this.jdField_a_of_type_Bdbb.d();
      this.jdField_a_of_type_Bdbb = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Altm);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Amgd);
    }
  }
  
  public long[] a()
  {
    long[] arrayOfLong = new long[this.jdField_c_of_type_Int];
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_b_of_type_JavaUtilArrayList.size(); j = k)
    {
      k = j;
      if (((ActivateFriendGridItem)this.jdField_b_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean)
      {
        arrayOfLong[j] = ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uin;
        k = j + 1;
      }
      i += 1;
    }
    return arrayOfLong;
  }
  
  public String[] a()
  {
    String[] arrayOfString = new String[this.jdField_c_of_type_Int];
    StringBuilder localStringBuilder = new StringBuilder(" ActivateFriendGrid friendsBirth:");
    int j = 0;
    int i = 0;
    Object localObject;
    int k;
    int m;
    int n;
    int i1;
    label131:
    String str;
    if (j < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      if (!((ActivateFriendGridItem)this.jdField_b_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_Boolean) {
        break label370;
      }
      long l = ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(j)).birthSendTime;
      localObject = new Time();
      ((Time)localObject).set(l * 1000L);
      k = ((Time)localObject).month;
      m = ((Time)localObject).monthDay;
      ((Time)localObject).setToNow();
      n = ((Time)localObject).year;
      i1 = ((Time)localObject).month;
      if (m < 10)
      {
        localObject = "-0";
        if (k >= 9) {
          break label240;
        }
        str = "-0";
        label141:
        if ((k != 0) || (i1 != 11)) {
          break label247;
        }
        arrayOfString[i] = (n + 1 + "-0" + (k + 1) + (String)localObject + m);
        label194:
        localStringBuilder.append(arrayOfString[i] + "|");
        i += 1;
      }
    }
    label240:
    label370:
    for (;;)
    {
      j += 1;
      break;
      localObject = "-";
      break label131;
      str = "-";
      break label141;
      label247:
      if ((k == 11) && (i1 == 0))
      {
        arrayOfString[i] = (n - 1 + "-" + (k + 1) + (String)localObject + m);
        break label194;
      }
      arrayOfString[i] = (n + str + (k + 1) + (String)localObject + m);
      break label194;
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriendGrid", 2, new Object[] { localStringBuilder });
      }
      return arrayOfString;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_Bdbb.a())
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
            ((ActivateFriendGridItem)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt1)).setHead(paramString);
          }
          paramInt1 += 1;
        }
        this.jdField_a_of_type_JavaUtilHashtable.clear();
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = 0;
    int i = this.jdField_b_of_type_JavaUtilArrayList.size();
    label22:
    int n;
    ActivateFriendGridItem localActivateFriendGridItem;
    int j;
    int k;
    int m;
    if (i > 3)
    {
      paramInt2 = 2;
      paramInt3 = 0;
      if (paramInt3 >= i) {
        break label290;
      }
      n = a(paramInt3, i);
      localActivateFriendGridItem = (ActivateFriendGridItem)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt3);
      j = localActivateFriendGridItem.getMeasuredHeight();
      k = localActivateFriendGridItem.getMeasuredWidth();
      paramInt4 = paramInt3 / 3;
      m = paramInt3 % 3;
      if (m != 0) {
        break label291;
      }
      paramInt1 = 0;
      if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
        paramInt1 = ((ActivateFriendGridItem)this.jdField_b_of_type_JavaUtilArrayList.get(0)).getMeasuredWidth();
      }
      if (paramInt1 * n + bdaq.a(getContext(), jdField_b_of_type_Int) * (n - 1) <= this.d) {
        break label242;
      }
      paramInt1 = (this.d - paramInt1 * n) / (n + 2);
      jdField_b_of_type_Int = paramInt1;
    }
    label158:
    label290:
    label291:
    for (;;)
    {
      if (paramInt2 > 1) {}
      for (paramInt4 = paramInt4 * j + paramInt4 * bdaq.a(getContext(), jdField_a_of_type_Int);; paramInt4 = this.e / 2 - j / 2)
      {
        m = m * k + paramInt1 + m * bdaq.a(getContext(), jdField_b_of_type_Int);
        localActivateFriendGridItem.layout(m, paramInt4, k + m, j + paramInt4);
        paramInt3 += 1;
        break label22;
        paramInt2 = 1;
        break;
        label242:
        paramInt1 = (this.d - paramInt1 * n - (n - 1) * bdaq.a(getContext(), jdField_b_of_type_Int)) / 2;
        break label158;
      }
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.d = getMeasuredWidth();
    this.e = a(paramInt2);
    setMeasuredDimension(getMeasuredWidth(), this.e);
  }
  
  public void setCheckAbilityEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setData(QQAppInterface paramQQAppInterface, ArrayList<ActivateFriendItem> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (jdField_a_of_type_AndroidGraphicsBitmap == null) {
      jdField_a_of_type_AndroidGraphicsBitmap = bdhj.a();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    paramQQAppInterface = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (paramQQAppInterface.hasNext()) {
      removeView((ActivateFriendGridItem)paramQQAppInterface.next());
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    if (this.jdField_a_of_type_Bdbb == null)
    {
      this.jdField_a_of_type_Bdbb = new bdbb(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Bdbb.a(this);
    }
    this.jdField_a_of_type_Amga = ((amga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(85));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Altm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Amgd);
    this.jdField_c_of_type_Int = 0;
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    if (i < j)
    {
      paramQQAppInterface = a();
      paramQQAppInterface.setIndex(i);
      paramQQAppInterface.setBirthday(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).birthdayDesc);
      paramQQAppInterface.setCheckViewGone();
      paramArrayList = String.valueOf(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uin);
      if (!TextUtils.isEmpty(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).nickName))
      {
        paramQQAppInterface.setNickName(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).nickName);
        label255:
        paramQQAppInterface.setHead(a(paramArrayList));
        if (this.jdField_a_of_type_Boolean) {
          paramQQAppInterface.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          if ((!getResources().getString(2131689585).equals(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).birthdayDesc)) && (!this.jdField_a_of_type_Amga.c(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uin, ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).type))) {
            break label405;
          }
          paramQQAppInterface.setChecked(false);
          paramQQAppInterface.setBirthday(getResources().getString(2131689585));
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilArrayList.add(paramQQAppInterface);
        i += 1;
        break;
        paramQQAppInterface.setNickName(bdgc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList, true));
        break label255;
        label405:
        if ((this.jdField_a_of_type_Amga.a(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uin, ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).type)) || (this.jdField_a_of_type_Amga.b(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uin, ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).type)))
        {
          paramQQAppInterface.setChecked(false);
          paramQQAppInterface.setBirthday(getResources().getString(2131689588));
        }
        else
        {
          this.jdField_c_of_type_Int += 1;
          paramQQAppInterface.setChecked(true);
        }
      }
    }
    if (this.jdField_a_of_type_Aenf != null) {
      this.jdField_a_of_type_Aenf.a(this.jdField_c_of_type_Int);
    }
  }
  
  public void setGridCallBack(aenf paramaenf)
  {
    this.jdField_a_of_type_Aenf = paramaenf;
  }
  
  public void setGridItemClickCallBack(aeng paramaeng)
  {
    this.jdField_a_of_type_Aeng = paramaeng;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid
 * JD-Core Version:    0.7.0.1
 */