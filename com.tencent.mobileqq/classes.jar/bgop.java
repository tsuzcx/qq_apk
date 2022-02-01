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
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Gallery;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bgop
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected FaceDecoder a;
  Setting jdField_a_of_type_ComTencentMobileqqDataSetting;
  Gallery jdField_a_of_type_ComTencentWidgetGallery;
  String jdField_a_of_type_JavaLangString;
  protected List<akjf> a;
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
  
  public bgop(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, Gallery paramGallery)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(7);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentWidgetGallery = paramGallery;
    this.jdField_a_of_type_Int = ((int)paramContext.getResources().getDimension(2131297492));
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    this.f = ThemeUtil.isInNightMode(paramQQAppInterface);
  }
  
  public akjf a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < getCount())) {
      return (akjf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public Rect a(int paramInt)
  {
    akjf localakjf = a(paramInt);
    Rect localRect = new Rect();
    if (localakjf != null) {
      akln.a(localRect, localakjf.d);
    }
    return localRect;
  }
  
  public String a(int paramInt)
  {
    akjf localakjf = a(paramInt);
    if (localakjf == null) {}
    String str;
    do
    {
      return null;
      str = localakjf.c;
    } while ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty(localakjf.jdField_b_of_type_JavaLangString)));
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return str;
      if ((localakjf.jdField_b_of_type_Int == 1) && ((localakjf.jdField_b_of_type_JavaLangString == null) || (!new File(localakjf.jdField_b_of_type_JavaLangString).exists()))) {
        str = bghb.b(bghb.a(localakjf.c, this.jdField_a_of_type_JavaLangString, 1));
      } else if ((localakjf.jdField_b_of_type_Int == 2) || ((localakjf.jdField_b_of_type_JavaLangString != null) && (new File(localakjf.jdField_b_of_type_JavaLangString).exists()))) {
        str = localakjf.jdField_b_of_type_JavaLangString;
      } else if (localakjf.jdField_b_of_type_Int == 3) {
        str = bghb.b(bghb.a(localakjf.c, this.jdField_a_of_type_JavaLangString, 0));
      } else {
        str = null;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt, bgor parambgor)
  {
    if ((parambgor == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
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
          localURLImageView = parambgor.jdField_a_of_type_ComTencentImageURLImageView;
          localImageProgressCircle = parambgor.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle;
          parambgor = a(paramInt);
          localRect = a(paramInt);
          if (QLog.isColorLevel()) {
            QLog.i("TroopAvatarWallGalleryAdapter", 2, "loadBigImage loadThumbImage() path = " + parambgor);
          }
        } while (TextUtils.isEmpty(parambgor));
        parambgor = akln.a(parambgor);
      } while (parambgor == null);
      localObject = a(paramInt);
    } while (localObject == null);
    Object localObject = ((akjf)localObject).c;
    if (((this.jdField_a_of_type_ComTencentMobileqqDataSetting == null) || (this.jdField_a_of_type_ComTencentMobileqqDataSetting.bHeadType == 0)) && (akjf.jdField_a_of_type_JavaLangString.equals(localObject)) && (!this.jdField_e_of_type_Boolean))
    {
      this.jdField_e_of_type_Boolean = true;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(this.jdField_a_of_type_JavaLangString, 4, true);
      }
    }
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      parambgor = URLDrawable.getDrawable(parambgor, (URLDrawable.URLDrawableOptions)localObject);
      parambgor.setTag(bgxc.a(localRect.left, localRect.top, localRect.width(), localRect.height(), this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
      parambgor.setDecodeHandler(bgxc.y);
    }
    for (;;)
    {
      if (this.f) {
        parambgor.setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
      }
      localURLImageView.setImageDrawable(parambgor);
      if (parambgor.getStatus() == 1) {
        break;
      }
      if (localImageProgressCircle.getVisibility() != 0) {
        localImageProgressCircle.setVisibility(0);
      }
      localImageProgressCircle.setProgress(0);
      localURLImageView.setURLDrawableDownListener(new bgoq(this, localImageProgressCircle, localURLImageView));
      return;
      if (!this.jdField_c_of_type_Boolean)
      {
        parambgor = URLDrawable.getDrawable(parambgor, (URLDrawable.URLDrawableOptions)localObject);
        paramInt = Math.min(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
        if (bdfk.b())
        {
          parambgor.setDecodeHandler(bgxc.j);
          parambgor.setTag(new int[] { paramInt, paramInt, (int)(paramInt * 0.07142858F) });
        }
        for (;;)
        {
          localURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          break;
          parambgor.setTag(bgxc.a(paramInt, paramInt));
          parambgor.setDecodeHandler(bgxc.b);
        }
      }
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_b_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_c_of_type_Int;
      parambgor = URLDrawable.getDrawable(parambgor, (URLDrawable.URLDrawableOptions)localObject);
      parambgor.setDecodeHandler(null);
      localURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
    a(localImageProgressCircle);
  }
  
  public void a(akjf paramakjf, bgmj parambgmj)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount())
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i).getTag();
      if ((localObject != null) && ((localObject instanceof bgmx)))
      {
        localObject = (bgor)localObject;
        if (((bgor)localObject).jdField_a_of_type_Akjf.equals(paramakjf))
        {
          if (paramakjf.jdField_a_of_type_Boolean) {
            break label82;
          }
          ((bgor)localObject).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle.setVisibility(8);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        ((bgor)localObject).jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle.setProgress(parambgmj.jdField_b_of_type_Int);
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
  
  public void a(List<akjf> paramList)
  {
    if (akjf.a(paramList, this.jdField_a_of_type_JavaUtilList))
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
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562977, null);
      paramView = new bgor(this);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368501));
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)localView.findViewById(2131368600));
      localView.setTag(paramView);
    }
    for (;;)
    {
      a(paramInt, paramView);
      paramView.jdField_a_of_type_Akjf = a(paramInt);
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(anvx.a(2131714571) + (paramInt + 1));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      bgor localbgor = (bgor)paramView.getTag();
      localView = paramView;
      paramView = localbgor;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgop
 * JD-Core Version:    0.7.0.1
 */