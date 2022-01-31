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

public class apxg
  extends apte
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplication.getContext().getResources().getDrawable(2130837919);
  public apvh a;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public apxg(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, apuc paramapuc, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramapuc);
    this.jdField_a_of_type_Apvh = new apxh(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private int a(apuf paramapuf)
  {
    if ((paramapuf instanceof apxf)) {
      return ((apxf)paramapuf).g;
    }
    if ((paramapuf instanceof apxv)) {
      return ((apxv)paramapuf).g;
    }
    return 0;
  }
  
  private String a(apuf paramapuf)
  {
    String str1 = "isUpdate";
    if ((paramapuf instanceof apxf)) {
      str1 = ((apxf)paramapuf).h;
    }
    for (;;)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("FavoriteEmotionAdapter", 2, "getRoamingType return null, " + paramapuf.toString());
        str2 = "isUpdate";
      }
      return str2;
      if ((paramapuf instanceof apxv)) {
        str1 = ((apxv)paramapuf).a;
      }
    }
  }
  
  private void a(apuf paramapuf, String paramString)
  {
    if ((paramapuf instanceof apxf)) {
      ((apxf)paramapuf).h = paramString;
    }
    while (!(paramapuf instanceof apxv)) {
      return;
    }
    ((apxv)paramapuf).a = paramString;
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
        paramURLImageView2.setImageDrawable((Drawable)BaseApplication.getContext().getResources().getDrawable(2130839225));
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
    ((URLImageView)localObject).setId(2131365668);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 56.0F), (int)(this.jdField_a_of_type_Float * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.jdField_a_of_type_Float));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject).setId(2131365646);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 56.0F), (int)(this.jdField_a_of_type_Float * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.jdField_a_of_type_Float));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject).setId(2131365669);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 56.0F), (int)(this.jdField_a_of_type_Float * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.jdField_a_of_type_Float));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    ((URLImageView)localObject).setVisibility(8);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject).setId(2131366010);
    ((RelativeLayout)localObject).setVisibility(8);
    ((RelativeLayout)localObject).setBackgroundResource(2130849805);
    localLayoutParams = new RelativeLayout.LayoutParams(azkz.a(10.0F), azkz.a(10.0F));
    localLayoutParams.addRule(3, 2131365668);
    localLayoutParams.addRule(7, 2131365668);
    localLayoutParams.addRule(6, 2131365668);
    localLayoutParams.topMargin = (-(int)(4.0F * this.jdField_a_of_type_Float));
    localLayoutParams.rightMargin = (-(int)(4.0F * this.jdField_a_of_type_Float));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setId(2131365667);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject).setBackgroundResource(2130837758);
    localLayoutParams.addRule(7, 2131365668);
    localLayoutParams.addRule(8, 2131365668);
    localLayoutParams.setMargins(0, 0, (int)(-5.0F * this.jdField_a_of_type_Float), (int)(-5.0F * this.jdField_a_of_type_Float));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setId(2131365674);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(7, 2131365668);
    localLayoutParams.addRule(8, 2131365668);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    if (AppSetting.c) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  private void b(View paramView, apws paramapws)
  {
    if ((paramView == null) || (!(paramapws instanceof apuf))) {
      QLog.e("FavoriteEmotionAdapter", 1, "emotionInfo or contentView = null");
    }
    apuf localapuf;
    Object localObject1;
    do
    {
      return;
      localapuf = (apuf)paramapws;
      paramView.setTag(localapuf);
      paramView.setVisibility(0);
      localObject1 = (RelativeLayout)paramView.findViewById(2131366010);
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setVisibility(8);
      }
      localObject1 = (URLImageView)paramView.findViewById(2131365668);
    } while (((URLImageView)localObject1).getTag(2131379971) == localapuf);
    ((URLImageView)localObject1).setTag(2131379971, paramapws);
    URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131365646);
    paramapws = (URLImageView)paramView.findViewById(2131365669);
    ImageView localImageView = (ImageView)paramView.findViewById(2131365667);
    ((URLImageView)localObject1).setVisibility(0);
    ((URLImageView)localObject1).setURLDrawableDownListener(null);
    Object localObject2 = localapuf.i;
    if ("favEdit".equals(localObject2))
    {
      ((URLImageView)localObject1).setImageDrawable(null);
      ((URLImageView)localObject1).setImageResource(2130839458);
      paramapws.setVisibility(8);
      localImageView.setVisibility(8);
      localURLImageView.setVisibility(8);
      if (AppSetting.c) {
        ((URLImageView)localObject1).setContentDescription(alud.a(2131704774));
      }
      paramView = (ImageView)paramView.findViewById(2131365674);
      if (!(localapuf instanceof apxv)) {
        break label618;
      }
      paramapws = (apxv)localapuf;
      if (!paramapws.b()) {
        break label611;
      }
      if (!paramapws.c()) {
        break label601;
      }
      paramView.setImageResource(2130838174);
    }
    for (;;)
    {
      paramView.setVisibility(0);
      return;
      if ("funny_pic".equals(localObject2))
      {
        ((URLImageView)localObject1).setImageDrawable(null);
        ((URLImageView)localObject1).setImageResource(2130846659);
        paramapws.setVisibility(8);
        localImageView.setVisibility(8);
        localURLImageView.setVisibility(8);
        if (!AppSetting.c) {
          break;
        }
        ((URLImageView)localObject1).setContentDescription(alud.a(2131704766));
        break;
      }
      localObject2 = localapuf.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float, (int)(56.0F * this.jdField_a_of_type_Float), (int)(56.0F * this.jdField_a_of_type_Float));
      ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if (AppSetting.c) {
        ((URLImageView)localObject1).setContentDescription(apoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Integer.valueOf(localapuf.g)));
      }
      String str = a(localapuf);
      if (QLog.isColorLevel()) {
        QLog.i("FavoriteEmotionAdapter", 2, "updateUI: roamingType = " + str);
      }
      if (str.equals("needUpload"))
      {
        localURLImageView.setImageDrawable(new ColorDrawable(-419430401));
        localURLImageView.setVisibility(0);
        localObject1 = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130839225);
        paramapws.setImageDrawable((Drawable)localObject1);
        ((Animatable)localObject1).start();
        paramapws.setVisibility(0);
        localImageView.setVisibility(8);
        break;
      }
      if (str.equals("failed"))
      {
        localURLImageView.setImageDrawable(new ColorDrawable(-419430401));
        paramapws.setVisibility(8);
        localImageView.setVisibility(0);
        localURLImageView.setVisibility(0);
        break;
      }
      paramapws.setVisibility(4);
      localImageView.setVisibility(4);
      localURLImageView.setVisibility(8);
      if (!(localObject2 instanceof URLDrawable)) {
        break;
      }
      ((URLImageView)localObject1).setURLDrawableDownListener(new apxi(this, localapuf, (URLImageView)localObject1, paramapws));
      a((URLImageView)localObject1, paramapws);
      break;
      label601:
      paramView.setImageResource(2130849830);
    }
    label611:
    paramView.setVisibility(8);
    return;
    label618:
    paramView.setVisibility(8);
  }
  
  public View a(aptf paramaptf, int paramInt, View paramView, ViewGroup paramViewGroup)
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
      paramViewGroup = (apxk)paramaptf;
      if (paramView != null) {
        break label507;
      }
      paramView = apxa.a().a(this.c);
      if (paramView != null) {
        break label345;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavoriteEmotionAdapter", 2, "getEmotionView position = " + paramInt + "; view from inflater");
      }
      paramaptf = new EmoticonPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, -1);
      paramaptf.setPanelType(EmoticonPanelLinearLayout.d);
      paramaptf.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      paramaptf.setOrientation(0);
      if (paramInt != 0) {
        break label243;
      }
      paramaptf.setPadding(0, (int)(16.0F * this.jdField_a_of_type_Float), 0, 0);
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
        paramaptf.addView(paramView);
        i += 1;
      }
      paramViewGroup = paramView.getClass().toString();
      break;
      label243:
      paramaptf.setPadding(0, (int)(14.0F * this.jdField_a_of_type_Float), 0, 0);
    }
    paramaptf.jdField_a_of_type_Apvh = this.jdField_a_of_type_Apvh;
    for (;;)
    {
      ((EmoticonPanelLinearLayout)paramaptf).setCallBack(this.jdField_a_of_type_Apuc);
      a(this.c, paramaptf);
      paramView = (ViewGroup)paramaptf;
      paramViewGroup.a = new RelativeLayout[this.jdField_a_of_type_Int];
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        paramViewGroup.a[i] = ((RelativeLayout)paramView.getChildAt(i));
        i += 1;
      }
      label345:
      paramaptf = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("FavoriteEmotionAdapter", 2, "getEmotionView position = " + paramInt + "; view from cache");
        paramaptf = paramView;
      }
    }
    paramaptf.setTag(paramViewGroup);
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
          b(paramViewGroup.a[i], (apws)this.jdField_a_of_type_JavaUtilList.get(j));
        }
      }
      if (QLog.isColorLevel()) {}
      return paramaptf;
      label507:
      paramaptf = paramView;
      i = j;
    }
  }
  
  public aptf a()
  {
    return new apxk();
  }
  
  public void a(List<apws> paramList)
  {
    super.a(paramList);
    apoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavoriteEmotionAdapter", 2, "refreshPanelData");
    }
    apwt localapwt = apwt.a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int j = this.c;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int;; i = -1)
    {
      localapwt.a(localQQAppInterface, j, null, -1, i, false, new apxj(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxg
 * JD-Core Version:    0.7.0.1
 */