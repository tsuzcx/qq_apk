import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bcnt
  extends BaseAdapter
  implements bcwt
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  protected bcws a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Setting jdField_a_of_type_ComTencentMobileqqDataSetting;
  Gallery jdField_a_of_type_ComTencentWidgetGallery;
  String jdField_a_of_type_JavaLangString;
  protected List<aiiy> a;
  boolean jdField_a_of_type_Boolean = false;
  protected int b;
  String jdField_b_of_type_JavaLangString = null;
  boolean jdField_b_of_type_Boolean = true;
  protected int c;
  boolean c;
  protected int d;
  boolean d;
  protected int e;
  boolean e;
  protected boolean f;
  
  public bcnt(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, Gallery paramGallery)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(7);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentWidgetGallery = paramGallery;
    this.jdField_a_of_type_Int = ((int)paramContext.getResources().getDimension(2131297345));
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_Bcws = new bcws(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_Bcws.a(this);
    this.f = ThemeUtil.isInNightMode(paramQQAppInterface);
  }
  
  public aiiy a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount())) {
      return (aiiy)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public Rect a(int paramInt)
  {
    aiiy localaiiy = a(paramInt);
    Rect localRect = new Rect();
    if (localaiiy != null) {
      ailp.a(localRect, localaiiy.d);
    }
    return localRect;
  }
  
  public String a(int paramInt)
  {
    aiiy localaiiy = a(paramInt);
    if (localaiiy == null) {}
    String str;
    do
    {
      return null;
      str = localaiiy.c;
    } while ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty(localaiiy.jdField_b_of_type_JavaLangString)));
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return str;
      if ((localaiiy.jdField_b_of_type_Int == 1) && ((localaiiy.jdField_b_of_type_JavaLangString == null) || (!new File(localaiiy.jdField_b_of_type_JavaLangString).exists()))) {
        str = bcgh.b(bcgh.a(localaiiy.c, this.jdField_a_of_type_JavaLangString, 1));
      } else if ((localaiiy.jdField_b_of_type_Int == 2) || ((localaiiy.jdField_b_of_type_JavaLangString != null) && (new File(localaiiy.jdField_b_of_type_JavaLangString).exists()))) {
        str = localaiiy.jdField_b_of_type_JavaLangString;
      } else if (localaiiy.jdField_b_of_type_Int == 3) {
        str = bcgh.b(bcgh.a(localaiiy.c, this.jdField_a_of_type_JavaLangString, 0));
      } else {
        str = null;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bcws.d();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt, bcnv parambcnv)
  {
    if ((parambcnv == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    URLImageView localURLImageView;
    ImageProgressCircle localImageProgressCircle;
    Rect localRect;
    do
    {
      do
      {
        do
        {
          return;
          localURLImageView = parambcnv.jdField_a_of_type_ComTencentImageURLImageView;
          localImageProgressCircle = parambcnv.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle;
          parambcnv = a(paramInt);
          localRect = a(paramInt);
          if (QLog.isColorLevel()) {
            QLog.i("TroopAvatarWallGalleryAdapter", 2, "loadBigImage loadThumbImage() path = " + parambcnv);
          }
        } while (TextUtils.isEmpty(parambcnv));
        parambcnv = ailp.a(parambcnv);
      } while (parambcnv == null);
      localObject = a(paramInt);
    } while (localObject == null);
    Object localObject = ((aiiy)localObject).c;
    if (((this.jdField_a_of_type_ComTencentMobileqqDataSetting == null) || (this.jdField_a_of_type_ComTencentMobileqqDataSetting.bHeadType == 0)) && (aiiy.jdField_a_of_type_JavaLangString.equals(localObject)) && (!this.jdField_e_of_type_Boolean))
    {
      this.jdField_e_of_type_Boolean = true;
      if (!this.jdField_a_of_type_Bcws.a()) {
        this.jdField_a_of_type_Bcws.a(this.jdField_a_of_type_JavaLangString, 4, true);
      }
    }
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = baul.a;
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      parambcnv = URLDrawable.getDrawable(parambcnv, (URLDrawable.URLDrawableOptions)localObject);
      parambcnv.setTag(bcuq.a(localRect.left, localRect.top, localRect.width(), localRect.height(), this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
      parambcnv.setDecodeHandler(bcuq.x);
    }
    for (;;)
    {
      if (this.f) {
        parambcnv.setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
      }
      localURLImageView.setImageDrawable(parambcnv);
      if (parambcnv.getStatus() == 1) {
        break;
      }
      if (localImageProgressCircle.getVisibility() != 0) {
        localImageProgressCircle.setVisibility(0);
      }
      localImageProgressCircle.setProgress(0);
      localURLImageView.setURLDrawableDownListener(new bcnu(this, localImageProgressCircle, localURLImageView));
      return;
      if (!this.jdField_c_of_type_Boolean)
      {
        parambcnv = URLDrawable.getDrawable(parambcnv, (URLDrawable.URLDrawableOptions)localObject);
        paramInt = Math.min(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
        if (azib.b())
        {
          parambcnv.setDecodeHandler(bcuq.i);
          parambcnv.setTag(new int[] { paramInt, paramInt, (int)(paramInt * 0.07142858F) });
        }
        for (;;)
        {
          localURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          break;
          parambcnv.setTag(bcuq.a(paramInt, paramInt));
          parambcnv.setDecodeHandler(bcuq.b);
        }
      }
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_b_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_c_of_type_Int;
      parambcnv = URLDrawable.getDrawable(parambcnv, (URLDrawable.URLDrawableOptions)localObject);
      parambcnv.setDecodeHandler(null);
      localURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
    a(localImageProgressCircle);
  }
  
  public void a(aiiy paramaiiy, bcln parambcln)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount())
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof bcme)))
      {
        localObject = (bcnv)localObject;
        if (((bcnv)localObject).jdField_a_of_type_Aiiy.equals(paramaiiy))
        {
          if (paramaiiy.jdField_a_of_type_Boolean) {
            break label82;
          }
          ((bcnv)localObject).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle.setVisibility(8);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        ((bcnv)localObject).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle.setProgress(parambcln.jdField_b_of_type_Int);
      }
    }
  }
  
  public void a(Setting paramSetting)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataSetting = paramSetting;
    notifyDataSetChanged();
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {}
    while (paramImageProgressCircle.getVisibility() == 4) {
      return;
    }
    paramImageProgressCircle.setVisibility(4);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(List<aiiy> paramList)
  {
    if (aiiy.a(paramList, this.jdField_a_of_type_JavaUtilList))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAvatarWallGalleryAdapter", 2, String.format("setAvatarList equal return", new Object[0]));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopAvatarWallGalleryAdapter", 2, String.format("setAvatarList %s", new Object[] { Arrays.deepToString(paramList.toArray()) }));
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562732, null);
      paramView = new bcnv(this);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131367910));
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)localView.findViewById(2131368010));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(paramInt, paramViewGroup);
      paramViewGroup.jdField_a_of_type_Aiiy = a(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(alpo.a(2131715590) + (paramInt + 1));
      return localView;
      paramViewGroup = (bcnv)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnt
 * JD-Core Version:    0.7.0.1
 */