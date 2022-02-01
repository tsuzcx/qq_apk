package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class ActivateFriendGrid
  extends FrameLayout
  implements DecodeTaskCompletionListener
{
  private static int jdField_a_of_type_Int = 15;
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private static int jdField_b_of_type_Int = 14;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ActivateFriendGrid.1(this);
  private ActivateFriendGrid.GridCallBack jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$GridCallBack = null;
  private ActivateFriendGrid.GridItemClickCallBack jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$GridItemClickCallBack = null;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ActivateFriendGrid.2(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ActivateFriendsManager jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager;
  ActivateFriendsObserver jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver = new ActivateFriendGrid.3(this);
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private ArrayList<ActivateFriendItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_a_of_type_Boolean = true;
  private ArrayList<ActivateFriendGridItem> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = true;
  private int d;
  private int e;
  
  public ActivateFriendGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt)
  {
    int i = this.jdField_b_of_type_JavaUtilArrayList.size();
    paramInt = 0;
    if (i > 0) {
      paramInt = ((ActivateFriendGridItem)this.jdField_b_of_type_JavaUtilArrayList.get(0)).getMeasuredHeight();
    }
    return paramInt * 2 + 1 * DisplayUtil.a(getContext(), jdField_a_of_type_Int);
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
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 1, true, (byte)0);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver);
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
    StringBuilder localStringBuilder1 = new StringBuilder(" ActivateFriendGrid friendsBirth:");
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_b_of_type_JavaUtilArrayList.size(); j = k)
    {
      k = j;
      if (((ActivateFriendGridItem)this.jdField_b_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean)
      {
        long l = ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).birthSendTime;
        Object localObject1 = new Time();
        ((Time)localObject1).set(l * 1000L);
        k = ((Time)localObject1).month;
        int m = ((Time)localObject1).monthDay;
        ((Time)localObject1).setToNow();
        int n = ((Time)localObject1).year;
        int i1 = ((Time)localObject1).month;
        if (m < 10) {
          localObject1 = "-0";
        } else {
          localObject1 = "-";
        }
        Object localObject2;
        if (k < 9) {
          localObject2 = "-0";
        } else {
          localObject2 = "-";
        }
        if ((k == 0) && (i1 == 11))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(n + 1);
          ((StringBuilder)localObject2).append("-0");
          ((StringBuilder)localObject2).append(k + 1);
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(m);
          arrayOfString[j] = ((StringBuilder)localObject2).toString();
        }
        else if ((k == 11) && (i1 == 0))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(n - 1);
          ((StringBuilder)localObject2).append("-");
          ((StringBuilder)localObject2).append(k + 1);
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(m);
          arrayOfString[j] = ((StringBuilder)localObject2).toString();
        }
        else
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(n);
          localStringBuilder2.append((String)localObject2);
          localStringBuilder2.append(k + 1);
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append(m);
          arrayOfString[j] = localStringBuilder2.toString();
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(arrayOfString[j]);
        ((StringBuilder)localObject1).append("|");
        localStringBuilder1.append(((StringBuilder)localObject1).toString());
        k = j + 1;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriendGrid", 2, new Object[] { localStringBuilder1 });
    }
    return arrayOfString;
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
    int i = this.jdField_b_of_type_JavaUtilArrayList.size();
    if (i > 3) {
      paramInt2 = 2;
    } else {
      paramInt2 = 1;
    }
    paramInt3 = 0;
    paramInt1 = 0;
    while (paramInt3 < i)
    {
      int n = a(paramInt3, i);
      ActivateFriendGridItem localActivateFriendGridItem = (ActivateFriendGridItem)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt3);
      int j = localActivateFriendGridItem.getMeasuredHeight();
      int k = localActivateFriendGridItem.getMeasuredWidth();
      paramInt4 = paramInt3 / 3;
      int m = paramInt3 % 3;
      if (m == 0)
      {
        if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
          paramInt1 = ((ActivateFriendGridItem)this.jdField_b_of_type_JavaUtilArrayList.get(0)).getMeasuredWidth();
        } else {
          paramInt1 = 0;
        }
        paramInt1 *= n;
        int i1 = DisplayUtil.a(getContext(), jdField_b_of_type_Int);
        int i2 = n - 1;
        int i3 = this.d;
        if (i1 * i2 + paramInt1 > i3)
        {
          paramInt1 = (i3 - paramInt1) / (n + 2);
          jdField_b_of_type_Int = paramInt1;
        }
        else
        {
          paramInt1 = (i3 - paramInt1 - DisplayUtil.a(getContext(), jdField_b_of_type_Int) * i2) / 2;
        }
      }
      if (paramInt2 > 1) {
        paramInt4 = paramInt4 * j + paramInt4 * DisplayUtil.a(getContext(), jdField_a_of_type_Int);
      } else {
        paramInt4 = this.e / 2 - j / 2;
      }
      m = m * k + paramInt1 + m * DisplayUtil.a(getContext(), jdField_b_of_type_Int);
      localActivateFriendGridItem.layout(m, paramInt4, k + m, j + paramInt4);
      paramInt3 += 1;
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
      jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.f();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    paramQQAppInterface = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (paramQQAppInterface.hasNext()) {
      removeView((ActivateFriendGridItem)paramQQAppInterface.next());
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
    this.jdField_c_of_type_Int = 0;
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      paramQQAppInterface = a();
      paramQQAppInterface.setIndex(i);
      paramQQAppInterface.setBirthday(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).birthdayDesc);
      paramQQAppInterface.setCheckViewGone();
      paramArrayList = String.valueOf(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uin);
      if (!TextUtils.isEmpty(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).nickName)) {
        paramQQAppInterface.setNickName(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).nickName);
      } else {
        paramQQAppInterface.setNickName(ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList, true));
      }
      paramQQAppInterface.setHead(a(paramArrayList));
      if (this.jdField_a_of_type_Boolean) {
        paramQQAppInterface.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      if (this.jdField_a_of_type_Boolean) {
        if ((!getResources().getString(2131689549).equals(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).birthdayDesc)) && (!this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.c(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uin, ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).type)))
        {
          if ((!this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uin, ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).type)) && (!this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.b(((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uin, ((ActivateFriendItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).type)))
          {
            this.jdField_c_of_type_Int += 1;
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
      i += 1;
    }
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$GridCallBack;
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(this.jdField_c_of_type_Int);
    }
  }
  
  public void setGridCallBack(ActivateFriendGrid.GridCallBack paramGridCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$GridCallBack = paramGridCallBack;
  }
  
  public void setGridItemClickCallBack(ActivateFriendGrid.GridItemClickCallBack paramGridItemClickCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$GridItemClickCallBack = paramGridItemClickCallBack;
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
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid
 * JD-Core Version:    0.7.0.1
 */