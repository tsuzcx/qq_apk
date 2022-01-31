import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class anhi
  extends angu
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplication.getContext().getResources().getDrawable(2130837712);
  public aniu a;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public anhi(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, anhs paramanhs, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanhs);
    this.jdField_a_of_type_Aniu = new anhj(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private void a(URLImageView paramURLImageView, ImageView paramImageView)
  {
    URLDrawable localURLDrawable = (URLDrawable)paramURLImageView.getBackground();
    if (localURLDrawable.getStatus() == 0)
    {
      paramURLImageView.setVisibility(8);
      paramImageView.setVisibility(0);
      if (!localURLDrawable.isDownloadStarted()) {
        localURLDrawable.startDownload();
      }
      if (!(paramImageView.getDrawable() instanceof Animatable)) {
        paramImageView.setImageDrawable((Drawable)BaseApplication.getContext().getResources().getDrawable(2130839113));
      }
      paramURLImageView = (Animatable)paramImageView.getDrawable();
      if (!paramURLImageView.isRunning()) {
        paramURLImageView.start();
      }
      return;
    }
    if ((localURLDrawable.getStatus() == 2) || (localURLDrawable.getStatus() == 3))
    {
      paramURLImageView.setVisibility(8);
      paramImageView.setVisibility(0);
      if ((paramImageView.getDrawable() instanceof Animatable)) {
        ((Animatable)paramImageView.getDrawable()).stop();
      }
      paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    paramURLImageView.setVisibility(0);
    paramImageView.setVisibility(8);
  }
  
  private RelativeLayout b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmotionAdapter", 2, "getCameraEmoView");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.d / this.jdField_a_of_type_Int, (int)(61.0F * this.jdField_a_of_type_Float)));
    Object localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject).setId(2131300003);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 56.0F), (int)(this.jdField_a_of_type_Float * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.jdField_a_of_type_Float));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setId(2131300004);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 56.0F), (int)(this.jdField_a_of_type_Float * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.jdField_a_of_type_Float));
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((ImageView)localObject).setAdjustViewBounds(false);
    ((ImageView)localObject).setVisibility(8);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setId(2131300009);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject).setBackgroundResource(2130837692);
    localLayoutParams.addRule(7, 2131300003);
    localLayoutParams.addRule(8, 2131300003);
    localLayoutParams.setMargins(0, 0, (int)(-5.0F * this.jdField_a_of_type_Float), (int)(-5.0F * this.jdField_a_of_type_Float));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    ((ImageView)localObject).setVisibility(8);
    if (AppSetting.c) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  private void b(View paramView, anjy paramanjy)
  {
    if ((paramView == null) || (!(paramanjy instanceof anhh))) {
      QLog.e("CameraEmotionAdapter", 1, "emotionInfo or contentView = null");
    }
    for (;;)
    {
      return;
      Object localObject = (URLImageView)paramView.findViewById(2131300003);
      anhh localanhh = (anhh)paramanjy;
      paramView.setTag(localanhh);
      paramView.setVisibility(0);
      if ((QLog.isColorLevel()) && (!baip.a(localanhh.h))) {
        QLog.d("CameraEmotionAdapter", 2, "updateUI info = " + localanhh.h);
      }
      if (((URLImageView)localObject).getTag(2131313373) != paramanjy)
      {
        ((URLImageView)localObject).setTag(2131313373, paramanjy);
        paramanjy = (ImageView)paramView.findViewById(2131300004);
        paramView = (ImageView)paramView.findViewById(2131300009);
        ((URLImageView)localObject).setVisibility(0);
        ((URLImageView)localObject).setURLDrawableDownListener(null);
        if ("cameraEdit".equals(localanhh.h))
        {
          ((URLImageView)localObject).setImageDrawable(null);
          ((URLImageView)localObject).setBackgroundResource(2130846021);
          paramanjy.setVisibility(4);
          paramView.setVisibility(4);
          if (AppSetting.c) {
            ((URLImageView)localObject).setContentDescription(ajjy.a(2131635515));
          }
        }
        else if ("cameraJump".equals(localanhh.h))
        {
          ((URLImageView)localObject).setImageDrawable(null);
          ((URLImageView)localObject).setBackgroundResource(2130837696);
          paramanjy.setVisibility(4);
          paramView.setVisibility(4);
          if (AppSetting.c) {
            ((URLImageView)localObject).setContentDescription(ajjy.a(2131635512));
          }
        }
        else
        {
          Drawable localDrawable = localanhh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
          ((URLImageView)localObject).setBackgroundDrawable(localDrawable);
          if (localanhh.g.equals("needUpload"))
          {
            ((URLImageView)localObject).setImageDrawable(new ColorDrawable(-419430401));
            localObject = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130839113);
            paramanjy.setImageDrawable((Drawable)localObject);
            ((Animatable)localObject).start();
            paramanjy.setVisibility(0);
            paramView.setVisibility(4);
          }
          while (!TextUtils.isEmpty(localanhh.c))
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "ep_mall", "0X800A370", 0, 0, "", "", localanhh.c, "");
            return;
            if (localanhh.g.equals("failed"))
            {
              ((URLImageView)localObject).setImageDrawable(new ColorDrawable(-419430401));
              paramanjy.setVisibility(4);
              paramView.setVisibility(0);
            }
            else
            {
              ((URLImageView)localObject).setImageDrawable(null);
              paramanjy.setVisibility(4);
              paramView.setVisibility(4);
              if ((localDrawable instanceof URLDrawable))
              {
                ((URLImageView)localObject).setURLDrawableDownListener(new anhk(this, localanhh, (URLImageView)localObject, paramanjy));
                a((URLImageView)localObject, paramanjy);
              }
            }
          }
        }
      }
    }
  }
  
  public View a(angv paramangv, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder().append("getEmotionView position = ").append(paramInt).append(" convertView NULL is ");
      if (paramView == null)
      {
        bool = true;
        QLog.d("CameraEmotionAdapter", 2, bool);
      }
    }
    else
    {
      paramViewGroup = (anhm)paramangv;
      if (paramView != null) {
        break label409;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionAdapter", 2, "getEmotionView position = " + paramInt + "; view from inflater");
      }
      paramangv = new EmoticonPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, -1);
      paramangv.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      paramangv.setOrientation(0);
      if (paramInt != 0) {
        break label217;
      }
    }
    label217:
    for (int i = 16;; i = 14)
    {
      paramangv.setPadding(0, (int)(i * this.jdField_a_of_type_Float), 0, 0);
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        paramView = b();
        paramView.setVisibility(8);
        paramView.setFocusable(true);
        paramView.setFocusableInTouchMode(true);
        paramangv.addView(paramView);
        i += 1;
      }
      bool = false;
      break;
    }
    paramangv.jdField_a_of_type_Aniu = this.jdField_a_of_type_Aniu;
    ((EmoticonPanelLinearLayout)paramangv).setCallBack(this.jdField_a_of_type_Anhs);
    paramView = (ViewGroup)paramangv;
    paramViewGroup.a = new RelativeLayout[this.jdField_a_of_type_Int];
    i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      paramViewGroup.a[i] = ((RelativeLayout)paramView.getChildAt(i));
      i += 1;
    }
    paramangv.setTag(paramViewGroup);
    i = j;
    for (;;)
    {
      if (i < this.jdField_a_of_type_Int)
      {
        j = this.jdField_a_of_type_Int * paramInt + i;
        if (j > this.jdField_a_of_type_JavaUtilList.size() - 1)
        {
          paramViewGroup.a[i].setTag(null);
          paramViewGroup.a[i].setVisibility(8);
        }
        for (;;)
        {
          i += 1;
          break;
          b(paramViewGroup.a[i], (anjy)this.jdField_a_of_type_JavaUtilList.get(j));
        }
      }
      return paramangv;
      label409:
      paramangv = paramView;
      i = j;
    }
  }
  
  public angv a()
  {
    return new anhm();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmotionAdapter", 2, "refreshPanelData");
    }
    anjz localanjz = anjz.a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int j = this.c;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int;; i = -1)
    {
      localanjz.a(localQQAppInterface, j, null, -1, i, false, new anhl(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anhi
 * JD-Core Version:    0.7.0.1
 */