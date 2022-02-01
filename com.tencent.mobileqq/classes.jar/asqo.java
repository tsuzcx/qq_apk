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

public class asqo
  extends aslt
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplication.getContext().getResources().getDrawable(2130838022);
  public asob a;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public asqo(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, asmr paramasmr, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramasmr);
    this.jdField_a_of_type_Asob = new asqp(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private int a(asmu paramasmu)
  {
    if ((paramasmu instanceof asqn)) {
      return ((asqn)paramasmu).g;
    }
    if ((paramasmu instanceof asre)) {
      return ((asre)paramasmu).g;
    }
    return 0;
  }
  
  private String a(asmu paramasmu)
  {
    String str1 = "isUpdate";
    if ((paramasmu instanceof asqn)) {
      str1 = ((asqn)paramasmu).h;
    }
    for (;;)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("FavoriteEmotionAdapter", 2, "getRoamingType return null, " + paramasmu.toString());
        str2 = "isUpdate";
      }
      return str2;
      if ((paramasmu instanceof asre)) {
        str1 = ((asre)paramasmu).a;
      }
    }
  }
  
  private void a(asmu paramasmu, String paramString)
  {
    if ((paramasmu instanceof asqn)) {
      ((asqn)paramasmu).h = paramString;
    }
    while (!(paramasmu instanceof asre)) {
      return;
    }
    ((asre)paramasmu).a = paramString;
  }
  
  private void a(URLImageView paramURLImageView1, URLImageView paramURLImageView2)
  {
    URLDrawable localURLDrawable;
    if ((paramURLImageView1.getDrawable() instanceof URLDrawable))
    {
      localURLDrawable = (URLDrawable)paramURLImageView1.getDrawable();
      if (localURLDrawable.getStatus() != 0) {
        break label102;
      }
      paramURLImageView1.setVisibility(8);
      paramURLImageView2.setVisibility(0);
      if (!localURLDrawable.isDownloadStarted()) {
        localURLDrawable.startDownload();
      }
      if (!(paramURLImageView2.getDrawable() instanceof Animatable)) {
        paramURLImageView2.setImageDrawable((Drawable)BaseApplication.getContext().getResources().getDrawable(2130839410));
      }
      paramURLImageView1 = (Animatable)paramURLImageView2.getDrawable();
      if (!paramURLImageView1.isRunning()) {
        paramURLImageView1.start();
      }
    }
    return;
    label102:
    if ((localURLDrawable.getStatus() == 2) || (localURLDrawable.getStatus() == 3))
    {
      paramURLImageView1.setVisibility(8);
      paramURLImageView2.setVisibility(0);
      if ((paramURLImageView2.getDrawable() instanceof Animatable)) {
        ((Animatable)paramURLImageView2.getDrawable()).stop();
      }
      paramURLImageView2.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    paramURLImageView1.setVisibility(0);
    paramURLImageView2.setVisibility(8);
  }
  
  private RelativeLayout b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavoriteEmotionAdapter", 2, "getFavouriteView");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.d / this.jdField_a_of_type_Int, (int)(61.0F * this.jdField_a_of_type_Float)));
    Object localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject).setId(2131365947);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 56.0F), (int)(this.jdField_a_of_type_Float * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.jdField_a_of_type_Float));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject).setId(2131365924);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 56.0F), (int)(this.jdField_a_of_type_Float * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.jdField_a_of_type_Float));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject).setId(2131365948);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 56.0F), (int)(this.jdField_a_of_type_Float * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.jdField_a_of_type_Float));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    ((URLImageView)localObject).setVisibility(8);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject).setId(2131366313);
    ((RelativeLayout)localObject).setVisibility(8);
    ((RelativeLayout)localObject).setBackgroundResource(2130850404);
    localLayoutParams = new RelativeLayout.LayoutParams(bdep.a(10.0F), bdep.a(10.0F));
    localLayoutParams.addRule(3, 2131365947);
    localLayoutParams.addRule(7, 2131365947);
    localLayoutParams.addRule(6, 2131365947);
    localLayoutParams.topMargin = (-(int)(4.0F * this.jdField_a_of_type_Float));
    localLayoutParams.rightMargin = (-(int)(4.0F * this.jdField_a_of_type_Float));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setId(2131365946);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject).setBackgroundResource(2130837996);
    localLayoutParams.addRule(7, 2131365947);
    localLayoutParams.addRule(8, 2131365947);
    localLayoutParams.setMargins(0, 0, (int)(-5.0F * this.jdField_a_of_type_Float), (int)(-5.0F * this.jdField_a_of_type_Float));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setId(2131365953);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(7, 2131365947);
    localLayoutParams.addRule(8, 2131365947);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    if (AppSetting.c) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  private void b(View paramView, aspq paramaspq)
  {
    if ((paramView == null) || (!(paramaspq instanceof asmu))) {
      QLog.e("FavoriteEmotionAdapter", 1, "emotionInfo or contentView = null");
    }
    asmu localasmu;
    Object localObject1;
    do
    {
      return;
      localasmu = (asmu)paramaspq;
      paramView.setTag(localasmu);
      paramView.setVisibility(0);
      localObject1 = (RelativeLayout)paramView.findViewById(2131366313);
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setVisibility(8);
      }
      localObject1 = (URLImageView)paramView.findViewById(2131365947);
    } while (((URLImageView)localObject1).getTag(2131381109) == localasmu);
    ((URLImageView)localObject1).setTag(2131381109, paramaspq);
    URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131365924);
    paramaspq = (URLImageView)paramView.findViewById(2131365948);
    ImageView localImageView = (ImageView)paramView.findViewById(2131365946);
    ((URLImageView)localObject1).setVisibility(0);
    ((URLImageView)localObject1).setURLDrawableDownListener(null);
    Object localObject2 = localasmu.i;
    if ("favEdit".equals(localObject2))
    {
      ((URLImageView)localObject1).setImageDrawable(null);
      ((URLImageView)localObject1).setImageResource(2130839641);
      paramaspq.setVisibility(8);
      localImageView.setVisibility(8);
      localURLImageView.setVisibility(8);
      if (AppSetting.c) {
        ((URLImageView)localObject1).setContentDescription(anzj.a(2131703278));
      }
      paramView = (ImageView)paramView.findViewById(2131365953);
      if (!(localasmu instanceof asre)) {
        break label618;
      }
      paramaspq = (asre)localasmu;
      if (!paramaspq.b()) {
        break label611;
      }
      if (!paramaspq.c()) {
        break label601;
      }
      paramView.setImageResource(2130838297);
    }
    for (;;)
    {
      paramView.setVisibility(0);
      return;
      if ("funny_pic".equals(localObject2))
      {
        ((URLImageView)localObject1).setImageDrawable(null);
        ((URLImageView)localObject1).setImageResource(2130847118);
        paramaspq.setVisibility(8);
        localImageView.setVisibility(8);
        localURLImageView.setVisibility(8);
        if (!AppSetting.c) {
          break;
        }
        ((URLImageView)localObject1).setContentDescription(anzj.a(2131703270));
        break;
      }
      localObject2 = localasmu.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float, (int)(56.0F * this.jdField_a_of_type_Float), (int)(56.0F * this.jdField_a_of_type_Float));
      ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if (AppSetting.c) {
        ((URLImageView)localObject1).setContentDescription(ashd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Integer.valueOf(localasmu.g)));
      }
      String str = a(localasmu);
      if (QLog.isColorLevel()) {
        QLog.i("FavoriteEmotionAdapter", 2, "updateUI: roamingType = " + str);
      }
      if (str.equals("needUpload"))
      {
        localURLImageView.setImageDrawable(new ColorDrawable(-419430401));
        localURLImageView.setVisibility(0);
        localObject1 = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130839410);
        paramaspq.setImageDrawable((Drawable)localObject1);
        ((Animatable)localObject1).start();
        paramaspq.setVisibility(0);
        localImageView.setVisibility(8);
        break;
      }
      if (str.equals("failed"))
      {
        localURLImageView.setImageDrawable(new ColorDrawable(-419430401));
        paramaspq.setVisibility(8);
        localImageView.setVisibility(0);
        localURLImageView.setVisibility(0);
        break;
      }
      paramaspq.setVisibility(4);
      localImageView.setVisibility(4);
      localURLImageView.setVisibility(8);
      if (!(localObject2 instanceof URLDrawable)) {
        break;
      }
      ((URLImageView)localObject1).setURLDrawableDownListener(new asqq(this, localasmu, (URLImageView)localObject1, paramaspq));
      a((URLImageView)localObject1, paramaspq);
      break;
      label601:
      paramView.setImageResource(2130850431);
    }
    label611:
    paramView.setVisibility(8);
    return;
    label618:
    paramView.setVisibility(8);
  }
  
  public View a(aslu paramaslu, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("getEmotionView position = ").append(paramInt).append(" convertView is ");
      if (paramView == null)
      {
        paramViewGroup = "null";
        QLog.d("FavoriteEmotionAdapter", 2, paramViewGroup);
      }
    }
    else
    {
      paramViewGroup = (asqs)paramaslu;
      if (paramView != null) {
        break label507;
      }
      paramView = aspy.a().a(this.c);
      if (paramView != null) {
        break label345;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavoriteEmotionAdapter", 2, "getEmotionView position = " + paramInt + "; view from inflater");
      }
      paramaslu = new EmoticonPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, -1);
      paramaslu.setPanelType(EmoticonPanelLinearLayout.d);
      paramaslu.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      paramaslu.setOrientation(0);
      if (paramInt != 0) {
        break label243;
      }
      paramaslu.setPadding(0, (int)(16.0F * this.jdField_a_of_type_Float), 0, 0);
    }
    for (;;)
    {
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        paramView = b();
        paramView.setVisibility(8);
        paramView.setFocusable(true);
        paramView.setFocusableInTouchMode(true);
        paramaslu.addView(paramView);
        i += 1;
      }
      paramViewGroup = paramView.getClass().toString();
      break;
      label243:
      paramaslu.setPadding(0, (int)(14.0F * this.jdField_a_of_type_Float), 0, 0);
    }
    paramaslu.jdField_a_of_type_Asob = this.jdField_a_of_type_Asob;
    for (;;)
    {
      ((EmoticonPanelLinearLayout)paramaslu).setCallBack(this.jdField_a_of_type_Asmr);
      a(this.c, paramaslu);
      paramView = (ViewGroup)paramaslu;
      paramViewGroup.a = new RelativeLayout[this.jdField_a_of_type_Int];
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        paramViewGroup.a[i] = ((RelativeLayout)paramView.getChildAt(i));
        i += 1;
      }
      label345:
      paramaslu = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("FavoriteEmotionAdapter", 2, "getEmotionView position = " + paramInt + "; view from cache");
        paramaslu = paramView;
      }
    }
    paramaslu.setTag(paramViewGroup);
    int i = j;
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
          b(paramViewGroup.a[i], (aspq)this.jdField_a_of_type_JavaUtilList.get(j));
        }
      }
      if (QLog.isColorLevel()) {}
      return paramaslu;
      label507:
      paramaslu = paramView;
      i = j;
    }
  }
  
  public aslu a()
  {
    return new asqs();
  }
  
  public void a(List<aspq> paramList)
  {
    super.a(paramList);
    ashd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavoriteEmotionAdapter", 2, "refreshPanelData");
    }
    aspr localaspr = aspr.a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int j = this.c;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int;; i = -1)
    {
      localaspr.a(localQQAppInterface, j, null, -1, i, false, new asqr(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqo
 * JD-Core Version:    0.7.0.1
 */