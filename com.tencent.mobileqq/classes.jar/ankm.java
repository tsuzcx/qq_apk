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

public class ankm
  extends angu
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplication.getContext().getResources().getDrawable(2130837712);
  public aniu a;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public ankm(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, anhs paramanhs, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanhs);
    this.jdField_a_of_type_Aniu = new ankn(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private int a(anht paramanht)
  {
    if ((paramanht instanceof ankl)) {
      return ((ankl)paramanht).jdField_g_of_type_Int;
    }
    if ((paramanht instanceof anla)) {
      return ((anla)paramanht).jdField_g_of_type_Int;
    }
    return 0;
  }
  
  private String a(anht paramanht)
  {
    String str1 = "isUpdate";
    if ((paramanht instanceof ankl)) {
      str1 = ((ankl)paramanht).jdField_g_of_type_JavaLangString;
    }
    for (;;)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("FavoriteEmotionAdapter", 2, "getRoamingType return null, " + paramanht.toString());
        str2 = "isUpdate";
      }
      return str2;
      if ((paramanht instanceof anla)) {
        str1 = ((anla)paramanht).a;
      }
    }
  }
  
  private void a(anht paramanht, String paramString)
  {
    if ((paramanht instanceof ankl)) {
      ((ankl)paramanht).jdField_g_of_type_JavaLangString = paramString;
    }
    while (!(paramanht instanceof anla)) {
      return;
    }
    ((anla)paramanht).a = paramString;
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
        paramURLImageView2.setImageDrawable((Drawable)BaseApplication.getContext().getResources().getDrawable(2130839113));
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
    ((URLImageView)localObject).setId(2131300003);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 56.0F), (int)(this.jdField_a_of_type_Float * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.jdField_a_of_type_Float));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject).setId(2131299982);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 56.0F), (int)(this.jdField_a_of_type_Float * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.jdField_a_of_type_Float));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject).setId(2131300004);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Float * 56.0F), (int)(this.jdField_a_of_type_Float * 56.0F));
    localLayoutParams.addRule(13, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, (int)(5.0F * this.jdField_a_of_type_Float));
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((URLImageView)localObject).setAdjustViewBounds(false);
    ((URLImageView)localObject).setVisibility(8);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject).setId(2131300321);
    ((RelativeLayout)localObject).setVisibility(8);
    ((RelativeLayout)localObject).setBackgroundResource(2130849057);
    localLayoutParams = new RelativeLayout.LayoutParams(awmc.a(10.0F), awmc.a(10.0F));
    localLayoutParams.addRule(3, 2131300003);
    localLayoutParams.addRule(7, 2131300003);
    localLayoutParams.addRule(6, 2131300003);
    localLayoutParams.topMargin = (-(int)(4.0F * this.jdField_a_of_type_Float));
    localLayoutParams.rightMargin = (-(int)(4.0F * this.jdField_a_of_type_Float));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setId(2131300002);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject).setBackgroundResource(2130837692);
    localLayoutParams.addRule(7, 2131300003);
    localLayoutParams.addRule(8, 2131300003);
    localLayoutParams.setMargins(0, 0, (int)(-5.0F * this.jdField_a_of_type_Float), (int)(-5.0F * this.jdField_a_of_type_Float));
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setId(2131300009);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(7, 2131300003);
    localLayoutParams.addRule(8, 2131300003);
    localRelativeLayout.addView((View)localObject, localLayoutParams);
    if (AppSetting.c) {
      localRelativeLayout.setFocusable(true);
    }
    return localRelativeLayout;
  }
  
  private void b(View paramView, anjy paramanjy)
  {
    if ((paramView == null) || (!(paramanjy instanceof anht))) {
      QLog.e("FavoriteEmotionAdapter", 1, "emotionInfo or contentView = null");
    }
    anht localanht;
    Object localObject1;
    do
    {
      return;
      localanht = (anht)paramanjy;
      paramView.setTag(localanht);
      paramView.setVisibility(0);
      localObject1 = (RelativeLayout)paramView.findViewById(2131300321);
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setVisibility(8);
      }
      localObject1 = (URLImageView)paramView.findViewById(2131300003);
    } while (((URLImageView)localObject1).getTag(2131313373) == localanht);
    ((URLImageView)localObject1).setTag(2131313373, paramanjy);
    URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131299982);
    paramanjy = (URLImageView)paramView.findViewById(2131300004);
    ImageView localImageView = (ImageView)paramView.findViewById(2131300002);
    ((URLImageView)localObject1).setVisibility(0);
    ((URLImageView)localObject1).setURLDrawableDownListener(null);
    Object localObject2 = localanht.h;
    if ("favEdit".equals(localObject2))
    {
      ((URLImageView)localObject1).setImageDrawable(null);
      ((URLImageView)localObject1).setImageResource(2130839347);
      paramanjy.setVisibility(8);
      localImageView.setVisibility(8);
      localURLImageView.setVisibility(8);
      if (AppSetting.c) {
        ((URLImageView)localObject1).setContentDescription(ajjy.a(2131638594));
      }
      paramView = (ImageView)paramView.findViewById(2131300009);
      if (!(localanht instanceof anla)) {
        break label618;
      }
      paramanjy = (anla)localanht;
      if (!paramanjy.b()) {
        break label611;
      }
      if (!paramanjy.c()) {
        break label601;
      }
      paramView.setImageResource(2130838110);
    }
    for (;;)
    {
      paramView.setVisibility(0);
      return;
      if ("funny_pic".equals(localObject2))
      {
        ((URLImageView)localObject1).setImageDrawable(null);
        ((URLImageView)localObject1).setImageResource(2130846020);
        paramanjy.setVisibility(8);
        localImageView.setVisibility(8);
        localURLImageView.setVisibility(8);
        if (!AppSetting.c) {
          break;
        }
        ((URLImageView)localObject1).setContentDescription(ajjy.a(2131638586));
        break;
      }
      localObject2 = localanht.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float, (int)(56.0F * this.jdField_a_of_type_Float), (int)(56.0F * this.jdField_a_of_type_Float));
      ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if (AppSetting.c) {
        ((URLImageView)localObject1).setContentDescription(anch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Integer.valueOf(localanht.jdField_g_of_type_Int)));
      }
      String str = a(localanht);
      if (QLog.isColorLevel()) {
        QLog.i("FavoriteEmotionAdapter", 2, "updateUI: roamingType = " + str);
      }
      if (str.equals("needUpload"))
      {
        localURLImageView.setImageDrawable(new ColorDrawable(-419430401));
        localURLImageView.setVisibility(0);
        localObject1 = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130839113);
        paramanjy.setImageDrawable((Drawable)localObject1);
        ((Animatable)localObject1).start();
        paramanjy.setVisibility(0);
        localImageView.setVisibility(8);
        break;
      }
      if (str.equals("failed"))
      {
        localURLImageView.setImageDrawable(new ColorDrawable(-419430401));
        paramanjy.setVisibility(8);
        localImageView.setVisibility(0);
        localURLImageView.setVisibility(0);
        break;
      }
      paramanjy.setVisibility(4);
      localImageView.setVisibility(4);
      localURLImageView.setVisibility(8);
      if (!(localObject2 instanceof URLDrawable)) {
        break;
      }
      ((URLImageView)localObject1).setURLDrawableDownListener(new anko(this, localanht, (URLImageView)localObject1, paramanjy));
      a((URLImageView)localObject1, paramanjy);
      break;
      label601:
      paramView.setImageResource(2130849080);
    }
    label611:
    paramView.setVisibility(8);
    return;
    label618:
    paramView.setVisibility(8);
  }
  
  public View a(angv paramangv, int paramInt, View paramView, ViewGroup paramViewGroup)
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
      paramViewGroup = (ankq)paramangv;
      if (paramView != null) {
        break label507;
      }
      paramView = ankg.a().a(this.c);
      if (paramView != null) {
        break label345;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavoriteEmotionAdapter", 2, "getEmotionView position = " + paramInt + "; view from inflater");
      }
      paramangv = new EmoticonPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, -1);
      paramangv.setPanelType(EmoticonPanelLinearLayout.d);
      paramangv.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      paramangv.setOrientation(0);
      if (paramInt != 0) {
        break label243;
      }
      paramangv.setPadding(0, (int)(16.0F * this.jdField_a_of_type_Float), 0, 0);
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
        paramangv.addView(paramView);
        i += 1;
      }
      paramViewGroup = paramView.getClass().toString();
      break;
      label243:
      paramangv.setPadding(0, (int)(14.0F * this.jdField_a_of_type_Float), 0, 0);
    }
    paramangv.jdField_a_of_type_Aniu = this.jdField_a_of_type_Aniu;
    for (;;)
    {
      ((EmoticonPanelLinearLayout)paramangv).setCallBack(this.jdField_a_of_type_Anhs);
      a(this.c, paramangv);
      paramView = (ViewGroup)paramangv;
      paramViewGroup.a = new RelativeLayout[this.jdField_a_of_type_Int];
      i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        paramViewGroup.a[i] = ((RelativeLayout)paramView.getChildAt(i));
        i += 1;
      }
      label345:
      paramangv = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d("FavoriteEmotionAdapter", 2, "getEmotionView position = " + paramInt + "; view from cache");
        paramangv = paramView;
      }
    }
    paramangv.setTag(paramViewGroup);
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
          b(paramViewGroup.a[i], (anjy)this.jdField_a_of_type_JavaUtilList.get(j));
        }
      }
      if (QLog.isColorLevel()) {}
      return paramangv;
      label507:
      paramangv = paramView;
      i = j;
    }
  }
  
  public angv a()
  {
    return new ankq();
  }
  
  public void a(List<anjy> paramList)
  {
    super.a(paramList);
    anch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FavoriteEmotionAdapter", 2, "refreshPanelData");
    }
    anjz localanjz = anjz.a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int j = this.c;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int;; i = -1)
    {
      localanjz.a(localQQAppInterface, j, null, -1, i, false, new ankp(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ankm
 * JD-Core Version:    0.7.0.1
 */