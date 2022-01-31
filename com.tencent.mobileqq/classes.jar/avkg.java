import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.16;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.17;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.20;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.8;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class avkg
  extends avjb
  implements View.OnClickListener
{
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "0X800554B", "0X800554C", "0X800554D", "0X800554E", "0X800554F", "0X8005550", "0X8005551" };
  int jdField_a_of_type_Int;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new avks(this);
  EditText jdField_a_of_type_AndroidWidgetEditText;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aoed jdField_a_of_type_Aoed = new avkk(this);
  private avky jdField_a_of_type_Avky;
  private baua jdField_a_of_type_Baua = new avkr(this);
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private PicInfo jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo;
  public NearbyPeopleProfileActivity a;
  public BounceScrollView a;
  String jdField_a_of_type_JavaLangString = "";
  final ArrayList<PicInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList(13);
  public LinkedList<PicInfo> a;
  int jdField_b_of_type_Int = 2015;
  View jdField_b_of_type_AndroidViewView;
  EditText jdField_b_of_type_AndroidWidgetEditText;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private aoed jdField_b_of_type_Aoed = new avkt(this);
  URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  final ArrayList<PicInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList(13);
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  EditText jdField_c_of_type_AndroidWidgetEditText;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  int jdField_d_of_type_Int;
  EditText jdField_d_of_type_AndroidWidgetEditText;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  int jdField_e_of_type_Int;
  EditText jdField_e_of_type_AndroidWidgetEditText;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  int jdField_f_of_type_Int;
  EditText jdField_f_of_type_AndroidWidgetEditText;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  int jdField_g_of_type_Int;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  int jdField_h_of_type_Int;
  TextView jdField_h_of_type_AndroidWidgetTextView;
  private int i;
  public TextView i;
  
  public avkg(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_Avky = new avky(this, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f);
    }
    this.jdField_h_of_type_Int = xod.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2.0F);
    this.jdField_a_of_type_Baua.addFilter(new Class[] { baqs.class });
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().a(this.jdField_a_of_type_Baua);
  }
  
  @TargetApi(11)
  private RelativeLayout a(PicInfo paramPicInfo, Drawable paramDrawable)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.setBackgroundResource(2130844582);
    Object localObject = new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f);
    ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, this.jdField_h_of_type_Int, 0);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((CustomImgView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    a(this.jdField_b_of_type_ComTencentImageURLImageView, paramPicInfo, paramDrawable);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localRelativeLayout.setOnDragListener(this.jdField_a_of_type_Avky);
    }
    localRelativeLayout.addView((View)localObject);
    localRelativeLayout.addView(b());
    localRelativeLayout.setTag(paramPicInfo);
    return localRelativeLayout;
  }
  
  private String a()
  {
    ArrayList localArrayList = new ArrayList(5);
    if (d()) {
      localArrayList.add(Integer.valueOf(1));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      if (!bdal.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname)) {
        localArrayList.add(Integer.valueOf(2));
      }
      if (((Byte)this.jdField_b_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender) {
        localArrayList.add(Integer.valueOf(3));
      }
      if (((Integer)((Object[])(Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag())[0]).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday) {
        localArrayList.add(Integer.valueOf(4));
      }
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_f_of_type_AndroidWidgetEditText.getTag())) {
        localArrayList.add(Integer.valueOf(5));
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (localArrayList.size() > 0)
    {
      int j = 0;
      if (j < localArrayList.size())
      {
        if (j != localArrayList.size() - 1) {
          localStringBuilder.append(localArrayList.get(j)).append("::");
        }
        for (;;)
        {
          j += 1;
          break;
          localStringBuilder.append(localArrayList.get(j));
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  private void a(View paramView1, View paramView2)
  {
    paramView2.postDelayed(new NearbyProfileEditTribePanel.20(this, paramView2, paramView1), 300L);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int j = 2131166895;; j = 2131166901)
    {
      paramTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColorStateList(j));
      return;
    }
  }
  
  private void a(TextView paramTextView, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    RichStatus localRichStatus;
    if (paramArrayOfByte != null)
    {
      localRichStatus = RichStatus.parseStatus(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
      if (localRichStatus != null) {
        paramArrayOfByte = localRichStatus.toSpannableString(null, -8947849, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131165307));
      }
      localObject = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject = new SpannableString("");
      }
      if ((localRichStatus == null) || (TextUtils.isEmpty(localRichStatus.actionText))) {
        break label225;
      }
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Axzt == null) {
        break label208;
      }
    }
    label208:
    for (paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Axzt.a(localRichStatus.actionId, 200);; paramArrayOfByte = bcwc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130848967))
    {
      paramArrayOfByte = new berh(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
      int j = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
      paramArrayOfByte.setBounds(0, 0, j, j);
      paramArrayOfByte = new bemz(paramArrayOfByte, 0);
      paramArrayOfByte.a(-0.1F);
      ((SpannableStringBuilder)localObject).setSpan(paramArrayOfByte, 0, "[S]".length(), 17);
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    label225:
    paramTextView.setText((CharSequence)localObject);
  }
  
  private void a(URLImageView paramURLImageView, PicInfo paramPicInfo, Drawable paramDrawable)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      QLog.d("Q.nearby_people_card.", 2, "setDrawable ,picInfo:" + paramPicInfo);
    }
    paramURLImageView.setTag(paramPicInfo);
    Object localObject = paramDrawable;
    if (paramDrawable == null)
    {
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setShape(0);
      ((GradientDrawable)localObject).setCornerRadius(bcwh.a(this.jdField_a_of_type_AndroidContentContext, 15.0F));
      ((GradientDrawable)localObject).setColor(-1579033);
    }
    try
    {
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f;
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f;
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      if ((paramPicInfo.jdField_c_of_type_JavaLangString != null) && (paramPicInfo.jdField_c_of_type_JavaLangString.length() > 0))
      {
        paramPicInfo = new File(paramPicInfo.jdField_c_of_type_JavaLangString).toURL();
        URLDrawable.removeMemoryCacheByUrl(paramPicInfo.toString());
        paramPicInfo = URLDrawable.getDrawable(paramPicInfo, localURLDrawableOptions);
        paramPicInfo.setDecodeHandler(bcuq.a);
        paramURLImageView.setImageDrawable(paramPicInfo);
        return;
      }
      paramDrawable = null;
      if (TextUtils.isEmpty(paramPicInfo.b)) {
        break label283;
      }
      paramDrawable = paramPicInfo.b;
    }
    catch (MalformedURLException paramURLImageView)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      while (QLog.isColorLevel())
      {
        paramPicInfo = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
        QLog.d("Q.nearby_people_card.", 2, "GridAdapter.getView() new URL(). " + paramURLImageView.getMessage(), paramURLImageView);
        return;
        if (!TextUtils.isEmpty(paramPicInfo.jdField_a_of_type_JavaLangString)) {
          paramDrawable = paramPicInfo.jdField_a_of_type_JavaLangString;
        }
      }
    }
    if (!TextUtils.isEmpty(paramDrawable))
    {
      paramPicInfo = URLDrawable.getDrawable(baqq.a(paramDrawable), localURLDrawableOptions);
      paramPicInfo.setDecodeHandler(bcuq.a);
      paramURLImageView.setImageDrawable(paramPicInfo);
      return;
    }
    label283:
  }
  
  private View b()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.setBackgroundResource(2130841092);
    Object localObject = new RelativeLayout.LayoutParams(xod.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 35.0F), xod.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 16.0F));
    int j = xod.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 5.0F);
    ((RelativeLayout.LayoutParams)localObject).setMargins(j, 0, 0, j);
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((TextView)localObject).setText(alpo.a(2131707676));
    ((TextView)localObject).setTextColor(-1);
    ((TextView)localObject).setTextSize(1, 12.0F);
    ((TextView)localObject).setSingleLine(true);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    localLayoutParams.setMargins(j, 0, j, 0);
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    localRelativeLayout.addView((View)localObject);
    localRelativeLayout.setVisibility(8);
    return localRelativeLayout;
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
      return true;
    }
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (k != this.jdField_b_of_type_JavaUtilArrayList.size()) {
      return true;
    }
    int j = 0;
    while (j < k)
    {
      if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
      {
        if (((PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_Int != ((PicInfo)this.jdField_b_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_Int) {
          return true;
        }
      }
      else {
        return false;
      }
      j += 1;
    }
    return false;
  }
  
  private boolean d()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      bool1 = true;
      return bool1;
    }
    int j = 0;
    for (;;)
    {
      bool1 = bool2;
      if (j >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      bool1 = bool2;
      if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
        break;
      }
      if (((PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_Int != ((PicInfo)this.jdField_b_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_Int) {
        return true;
      }
      j += 1;
    }
  }
  
  private boolean e()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (!bdje.a(str))
    {
      if (bdje.d(str).length() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(alpo.a(2131707711));
        return false;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(alpo.a(2131707635));
      return false;
    }
    return true;
  }
  
  private void i()
  {
    j();
  }
  
  private void j()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add((PicInfo)this.jdField_b_of_type_ComTencentImageURLImageView.getTag());
    if (QLog.isColorLevel())
    {
      NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      QLog.d("Q.nearby_people_card.", 2, "reorganizePicInfo:" + this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131707733));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131707701));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 10.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131368613).setVisibility(8);
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368615);
    localTextView.setVisibility(0);
    localTextView.setText(2131690648);
    localTextView.setOnClickListener(new avkl(this));
    localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368644);
    localTextView.setVisibility(0);
    localTextView.setText(2131692680);
    localTextView.setEnabled(true);
    localTextView.setOnClickListener(new avkm(this));
    this.jdField_b_of_type_AndroidViewView.findViewById(2131375812).setOnClickListener(this);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      localObject = new StringBuilder(alpo.a(2131707727));
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int - this.jdField_a_of_type_JavaUtilLinkedList.size() + 1).append("/").append(this.jdField_a_of_type_Int).append(")...");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(((StringBuilder)localObject).toString());
      localObject = new NearbyProfileEditTribePanel.16(this);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a((Runnable)localObject);
      return;
    }
    f();
    Object localObject = new Intent("tribe_profile_edit_finish");
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
  }
  
  protected int a()
  {
    return 2131561067;
  }
  
  Intent a(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, PhotoCropActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    paramString = aljq.aX + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin() + "/" + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", paramString + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.QZONE_COVER_CROP_LEFT_TITLE", alpo.a(2131707729));
    localIntent.putExtra("FROM_WHERE", "FROM_NEARBY_PROFILE");
    return localIntent;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().b(this.jdField_a_of_type_Baua);
  }
  
  public void a(int paramInt)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    String str = aljq.aX + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin() + "/" + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(localIntent);
    bdar.anim(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, false, true);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800481F", "0X800481F", 1, 0, "", "", "", "");
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = this.jdField_b_of_type_Int - (paramInt1 + 1896);
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(1, paramInt2 + 1, paramInt3 + 1);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).set(1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    int j = k;
    if (((Calendar)localObject1).after(localObject2)) {
      j = k - 1;
    }
    k = j;
    if (j < 0) {
      k = 0;
    }
    paramInt1 += 1896;
    j = paramInt2 + 1;
    int m = paramInt3 + 1;
    localObject1 = bdal.a(paramInt2 + 1, paramInt3 + 1);
    paramInt2 = AgeSelectionActivity.a((String)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramInt1).append("-").append(j).append("-").append(m).append(" ").append("(").append(k).append("岁").append(" ").append((String)localObject1).append(")");
    this.jdField_c_of_type_AndroidWidgetEditText.setText(((StringBuilder)localObject2).toString());
    this.jdField_c_of_type_AndroidWidgetEditText.setTag(new Object[] { Integer.valueOf(paramInt1 << 16 | j << 8 | m), Integer.valueOf(k), Integer.valueOf(paramInt2) });
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((paramInt2 == -1) && (paramIntent != null))
          {
            paramIntent = paramIntent.getByteArrayExtra("param_new_xuan_yan");
            if (this.jdField_f_of_type_AndroidWidgetEditText != null)
            {
              a(this.jdField_f_of_type_AndroidWidgetEditText, paramIntent);
              this.jdField_f_of_type_AndroidWidgetEditText.setTag(paramIntent);
              return;
              if ((paramInt2 == -1) && (paramIntent != null))
              {
                Object localObject1 = paramIntent.getStringExtra("key_cover_selected_img_path");
                this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("key_album_id");
                if (!bdje.a((String)localObject1))
                {
                  paramInt1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e;
                  paramIntent = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
                  if ((paramInt1 == 1) && (this.jdField_a_of_type_JavaUtilArrayList.size() < NearbyPeopleProfileActivity.jdField_c_of_type_Int))
                  {
                    paramIntent = a((String)localObject1);
                    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramIntent);
                    return;
                    if (paramIntent != null)
                    {
                      paramIntent = paramIntent.getExtras();
                      paramIntent.getString("video_id");
                      paramIntent.getInt("head_id");
                      return;
                      if ((paramInt2 == -1) && (this.jdField_d_of_type_AndroidWidgetEditText != null))
                      {
                        localObject1 = paramIntent.getStringExtra("param_name");
                        paramInt1 = paramIntent.getIntExtra("param_id", -1);
                        Object localObject2 = paramIntent.getStringExtra("param_tag");
                        paramInt2 = paramIntent.getIntExtra("param_tag_bg", -1);
                        if ((localObject2 != null) && (((String)localObject2).length() > 0) && (paramInt2 > 0))
                        {
                          this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
                          this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundResource(paramInt2);
                          this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
                        }
                        for (;;)
                        {
                          this.jdField_d_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
                          this.jdField_d_of_type_AndroidWidgetEditText.setTag(Integer.valueOf(paramInt1));
                          return;
                          this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
                        }
                        if (paramInt2 == -1)
                        {
                          localObject2 = paramIntent.getStringArrayExtra("param_location");
                          try
                          {
                            paramIntent = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Allj.a((String[])localObject2);
                            if (paramIntent != null)
                            {
                              localObject1 = paramIntent;
                              if (!paramIntent.equals("不限")) {}
                            }
                            else
                            {
                              localObject1 = "";
                            }
                            if (this.jdField_e_of_type_AndroidWidgetEditText != null)
                            {
                              this.jdField_e_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
                              this.jdField_e_of_type_AndroidWidgetEditText.setTag(localObject2);
                              return;
                            }
                          }
                          catch (Exception paramIntent)
                          {
                            for (;;)
                            {
                              paramIntent = null;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      } while (paramInt2 != -1);
      paramIntent = paramIntent.getParcelableArrayListExtra("intent_param_pic_infos");
    } while ((paramIntent == null) || (paramIntent.size() == 0));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    paramInt1 = 0;
    while (paramInt1 < paramIntent.size())
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a((PicInfo)paramIntent.get(paramInt1), null));
      paramInt1 += 1;
    }
    i();
  }
  
  protected void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
    paramView.findViewById(2131377935).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377975));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377914));
    paramView.findViewById(2131368659).setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379671));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372221));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371805));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377141));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131371142));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131367103));
    this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131362209));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131362973));
    this.jdField_f_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131380300));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365597));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.mScrollFlag = 1;
    k();
    bcht.b("profile_edit", "exp", "", "", "", "");
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    Object localObject;
    int j;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      if ("EditPanel bindData, isEditing = " + this.jdField_a_of_type_Boolean + ", mActivity.mPicInfo.size = " + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList == null)
      {
        localObject = "null";
        QLog.d("Q.nearby_people_card.", 2, new Object[] { localObject });
      }
    }
    else
    {
      j = ((Integer)aush.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_edit", 0, 0, ausq.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_j_of_type_Int), j + "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList.size() <= 0)) {
        break label802;
      }
      a(this.jdField_b_of_type_ComTencentImageURLImageView, (PicInfo)this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.picList.get(0), null);
      label216:
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.h)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_b_of_type_JavaUtilArrayList.clear();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 0) {
        break label833;
      }
      this.jdField_a_of_type_JavaLangString = alpo.a(2131707721);
      label318:
      if (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) {
        break label857;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694718));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      this.jdField_b_of_type_AndroidWidgetEditText.setText(bcyr.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender));
      this.jdField_b_of_type_AndroidWidgetEditText.setTag(Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender));
      j = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age;
      int k = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday;
      int m = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation;
      int n = (0xFF00 & k) >> 8;
      int i1 = k & 0xFF;
      paramNearbyPeopleCard = bdal.a(n, i1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(k >> 16).append("-").append(n).append("-").append(i1).append(" ").append("(").append(j).append("岁").append(" ").append(paramNearbyPeopleCard).append(")");
      this.jdField_c_of_type_AndroidWidgetEditText.setText(((StringBuilder)localObject).toString());
      this.jdField_c_of_type_AndroidWidgetEditText.setTag(new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m) });
      j = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job;
      a(this.jdField_f_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
      this.jdField_f_of_type_AndroidWidgetEditText.setTag(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_j_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.k == 1)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new NearbyProfileEditTribePanel.8(this), 300L);
      }
      this.jdField_b_of_type_AndroidViewView.findViewById(2131380301).setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131367106).setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131362211).setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131362989).setOnClickListener(this);
      this.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new avkx(this));
      this.jdField_f_of_type_AndroidWidgetEditText.addTextChangedListener(new avki(this));
      this.jdField_a_of_type_AndroidWidgetEditText.getViewTreeObserver().addOnGlobalLayoutListener(new avkj(this));
      return;
      localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size());
      break;
      label802:
      paramNearbyPeopleCard = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      paramNearbyPeopleCard = bcxb.a(paramNearbyPeopleCard, 1, paramNearbyPeopleCard.getCurrentAccountUin());
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(paramNearbyPeopleCard);
      break label216;
      label833:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
        break label318;
      }
      this.jdField_a_of_type_JavaLangString = alpo.a(2131707672);
      break label318;
      label857:
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > NearbyPeopleProfileActivity.jdField_b_of_type_Int) {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694719, new Object[] { this.jdField_a_of_type_JavaLangString }));
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    int k = 1;
    int j = 1;
    this.jdField_b_of_type_Boolean = true;
    if (TextUtils.isEmpty(paramString))
    {
      this.i = 1;
      this.g.setText("");
      paramInt = 0;
      if (paramInt != 0)
      {
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006784", "0X8006784", 0, 0, "", "", "", "");
      }
    }
    else
    {
      if (paramInt == 0)
      {
        if (TextUtils.equals(this.g.getText().toString(), paramString)) {
          if (this.i == 2) {
            paramInt = j;
          }
        }
        for (;;)
        {
          this.g.setText(paramString);
          break;
          paramInt = 0;
          continue;
          this.i = paramInt;
          paramInt = 0;
        }
      }
      if (paramInt == 2) {}
      for (j = k;; j = 0)
      {
        this.i = paramInt;
        paramInt = j;
        break;
      }
    }
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_c_of_type_Boolean) {
      return true;
    }
    if (d()) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_f_of_type_AndroidWidgetEditText.getTag())) {
        return true;
      }
      if (!bdal.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname)) {
        return true;
      }
      if (((Byte)this.jdField_b_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender) {
        return true;
      }
      if (((Integer)((Object[])(Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag())[0]).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(PicInfo paramPicInfo)
  {
    a(this.jdField_b_of_type_ComTencentImageURLImageView, paramPicInfo, null);
    i();
    return true;
  }
  
  int b()
  {
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    int j = 0;
    while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      PicInfo localPicInfo = (PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (localPicInfo.jdField_a_of_type_Int == -1) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(localPicInfo);
      }
      j += 1;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilLinkedList.size();
    return this.jdField_a_of_type_Int;
  }
  
  public void b() {}
  
  public boolean b()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int k = this.jdField_b_of_type_JavaUtilArrayList.size();
    if ((k <= 0) && (j >= 1)) {
      return true;
    }
    if ((k >= 1) && (j <= 0)) {
      return true;
    }
    if ((k >= 1) && (j >= 1)) {
      return ((PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int != ((PicInfo)this.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int;
    }
    return false;
  }
  
  public void c()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, LocationSelectActivity.class);
    localIntent.putExtra("param_req_type", 3);
    allj localallj = (allj)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(59);
    int j = localallj.a();
    Object localObject1;
    if (j != 0)
    {
      j = localallj.a(j, true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "startLocationSelectActivity | update result = " + j);
      }
      if (j == 2)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131694766, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
        return;
      }
      if (j == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131691084));
        localallj.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Alln);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131691084));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      ((Handler)localObject1).sendEmptyMessageDelayed(206, 20000L);
      return;
    }
    Object localObject2 = (String[])this.jdField_e_of_type_AndroidWidgetEditText.getTag();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length == 4) {}
    }
    else
    {
      localObject1 = new String[4];
      localObject1[0] = "0";
      localObject1[1] = "0";
      localObject1[2] = "0";
      localObject1[3] = "0";
    }
    localIntent.putExtra("param_location", (String[])localObject1);
    localIntent.putExtra("param_is_popup", false);
    localIntent.putExtra("param_location_param", localallj.b((String[])localObject1));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 4);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) {}
    String[] arrayOfString;
    String str;
    do
    {
      return;
      arrayOfString = new String[4];
      arrayOfString[0] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry;
      arrayOfString[1] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice;
      arrayOfString[2] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity;
      arrayOfString[3] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict;
      str = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Allj.a(arrayOfString);
    } while (this.jdField_e_of_type_AndroidWidgetEditText == null);
    if (!"不限".equals(str)) {
      this.jdField_e_of_type_AndroidWidgetEditText.setText(str);
    }
    this.jdField_e_of_type_AndroidWidgetEditText.setTag(arrayOfString);
  }
  
  void e()
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004823", "0X8004823", 0, 0, "", "", "", "");
    bcht.b("profile_edit", "suc_edit", a(), "", "", "");
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "doOldSaveAction, picInfo size|" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    l();
  }
  
  void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "saveNearbyProfileCard");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(alpo.a(2131707713));
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    if (c())
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 10, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e != 1) {
        break label696;
      }
    }
    label679:
    label696:
    for (int j = 1;; j = 3)
    {
      Object localObject;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0))
      {
        localObject = "1";
        azmj.b(null, "dc00899", "grp_lbs", "", "data_card", "upload_video", 0, 0, "", (String)localObject, "", String.valueOf(j));
        j = ((Integer)aush.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "suc_edit", 0, 0, ausq.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_j_of_type_Int), j + "", "", "");
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("key_is_nearby_people_card", true);
        localBundle.putShort("key_new_profile_modified_flag", (short)1);
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
        {
          byte[] arrayOfByte = (byte[])this.jdField_f_of_type_AndroidWidgetEditText.getTag();
          localObject = arrayOfByte;
          if (arrayOfByte == null) {
            localObject = new byte[0];
          }
          localBundle.putByteArray("key_xuan_yan", (byte[])localObject);
          if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_f_of_type_AndroidWidgetEditText.getTag()))
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d = true;
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 2, 0, "", "", "", "");
          }
          localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname))
          {
            localBundle.putString("key_new_nickname", (String)localObject);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d = true;
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 1, 0, "", "", "", "");
          }
          byte b1 = ((Byte)this.jdField_b_of_type_AndroidWidgetEditText.getTag()).byteValue();
          if (b1 != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender)
          {
            localBundle.putByte("sex", b1);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d = true;
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 4, 0, "", "", "", "");
          }
          localObject = (Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag();
          j = ((Integer)localObject[0]).intValue();
          if (j != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday)
          {
            localBundle.putInt("birthday", j);
            localBundle.putInt("age", ((Integer)localObject[1]).intValue());
            localBundle.putInt("key_constellation", ((Integer)localObject[2]).intValue());
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 5, 0, "", "", "", "");
          }
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Ausy;
        if (localObject == null) {
          break label679;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(new NearbyProfileEditTribePanel.17(this, (ausy)localObject, localBundle, localArrayList));
      }
      while (!QLog.isDevelopLevel())
      {
        return;
        localObject = "2";
        break;
      }
      QLog.i("Q.nearby_people_card.", 4, "NearbyCardHandler is null");
      return;
    }
  }
  
  public void g()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, JobSelectionActivity.class);
    if ((this.jdField_d_of_type_AndroidWidgetEditText != null) && (this.jdField_d_of_type_AndroidWidgetEditText.getTag() != null) && ((this.jdField_d_of_type_AndroidWidgetEditText.getTag() instanceof Integer))) {
      localIntent.putExtra("param_id", (Integer)this.jdField_d_of_type_AndroidWidgetEditText.getTag());
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 3);
  }
  
  public void h()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, EditActivity.class);
    localIntent.putExtra("param_entry", 1);
    localIntent.putExtra("param_old_xuan_yan", (byte[])this.jdField_f_of_type_AndroidWidgetEditText.getTag());
    localIntent.putExtra("max_word_count", 30);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 1);
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    int k;
    if ((paramView.getId() == 2131367106) || (paramView == this.jdField_b_of_type_AndroidWidgetEditText))
    {
      localObject1 = bhpy.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      localObject2 = (DispatchActionMoveScrollView)((bhpy)localObject1).findViewById(2131361924);
      ((DispatchActionMoveScrollView)localObject2).jdField_a_of_type_Boolean = true;
      ((DispatchActionMoveScrollView)localObject2).setBackgroundResource(17170445);
      localObject2 = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2131560987, null);
      ((IphonePickerView)localObject2).a(this.jdField_b_of_type_Aoed);
      if (this.jdField_b_of_type_AndroidWidgetEditText.getTag() != null)
      {
        k = ((Byte)this.jdField_b_of_type_AndroidWidgetEditText.getTag()).byteValue();
        if (k >= 0)
        {
          j = k;
          if (k <= 1) {}
        }
        else
        {
          j = 0;
        }
        ((IphonePickerView)localObject2).setSelection(0, j);
        ((IphonePickerView)localObject2).setPickListener(new avkh(this, (IphonePickerView)localObject2, (bhpy)localObject1));
        ((bhpy)localObject1).a(new avku(this));
        ((bhpy)localObject1).a((View)localObject2, null);
        ((bhpy)localObject1).show();
        a(paramView, ((bhpy)localObject1).a());
        a(this.jdField_b_of_type_AndroidWidgetEditText, false);
      }
    }
    Object localObject3;
    do
    {
      return;
      if ((paramView.getId() == 2131368972) || (paramView == this.jdField_d_of_type_AndroidWidgetEditText))
      {
        g();
        return;
      }
      if (paramView == this.jdField_b_of_type_AndroidWidgetLinearLayout)
      {
        paramView = this.g.getText().toString();
        paramView = bhos.a(bhos.a(bhos.a(bhos.a("https://qun.qq.com/qqweb/m/nearby/pages/school_edit.html", "_bid", "2473"), "_wv", "1031"), "schoolName", paramView), "isValid", String.valueOf(this.i));
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
        return;
      }
      if ((paramView.getId() == 2131367693) || (paramView == this.jdField_e_of_type_AndroidWidgetEditText))
      {
        c();
        return;
      }
      if ((paramView.getId() == 2131380301) || (paramView == this.jdField_f_of_type_AndroidWidgetEditText))
      {
        h();
        return;
      }
      if ((paramView.getId() != 2131362211) && (paramView != this.jdField_c_of_type_AndroidWidgetEditText)) {
        break;
      }
      localObject1 = bhpy.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      localObject2 = Calendar.getInstance();
      this.jdField_b_of_type_Int = ((Calendar)localObject2).get(1);
      localObject3 = (DispatchActionMoveScrollView)((bhpy)localObject1).findViewById(2131361924);
      ((DispatchActionMoveScrollView)localObject3).jdField_a_of_type_Boolean = true;
      ((DispatchActionMoveScrollView)localObject3).setBackgroundResource(17170445);
      localObject3 = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2131560987, null);
      ((IphonePickerView)localObject3).a(this.jdField_a_of_type_Aoed);
    } while (this.jdField_c_of_type_AndroidWidgetEditText.getTag() == null);
    int j = ((Integer)((Object[])(Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag())[0]).intValue();
    int m;
    if (j == 0)
    {
      k = 0;
      m = 94;
    }
    for (j = 0;; j = (j & 0xFF) - 1)
    {
      ((Calendar)localObject2).setTimeInMillis(System.currentTimeMillis());
      this.jdField_b_of_type_Int = ((Calendar)localObject2).get(1);
      this.jdField_c_of_type_Int = (((Calendar)localObject2).get(2) + 1);
      this.jdField_d_of_type_Int = ((Calendar)localObject2).get(5);
      ((IphonePickerView)localObject3).setPickListener(new avkv(this, (IphonePickerView)localObject3, (bhpy)localObject1));
      ((IphonePickerView)localObject3).setSelection(0, m);
      ((IphonePickerView)localObject3).setSelection(1, k);
      ((IphonePickerView)localObject3).setSelection(2, j);
      ((bhpy)localObject1).a(new avkw(this));
      ((bhpy)localObject1).a((View)localObject3, null);
      ((bhpy)localObject1).show();
      a(paramView, ((bhpy)localObject1).a());
      a(this.jdField_c_of_type_AndroidWidgetEditText, false);
      return;
      m = (j >>> 16) - 1896;
      k = ((0xFF00 & j) >>> 8) - 1;
    }
    if (paramView == this.jdField_a_of_type_ComTencentImageURLImageView)
    {
      if (auss.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app)) {
        break label857;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.jdField_a_of_type_JavaLangString)))
      {
        auss.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, null, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.d, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.videoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e, true);
        j = 1;
      }
    }
    for (;;)
    {
      auss.a("clk_video_entry", new String[] { "" + j, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, "1" });
      return;
      auss.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, 2);
      j = 2;
      continue;
      if (((paramView.getId() != 2131362989) && (paramView != this.jdField_b_of_type_ComTencentImageURLImageView)) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
        break;
      }
      a(this.jdField_a_of_type_JavaUtilArrayList.size());
      return;
      label857:
      j = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avkg
 * JD-Core Version:    0.7.0.1
 */