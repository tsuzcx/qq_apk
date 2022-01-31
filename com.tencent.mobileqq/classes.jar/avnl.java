import android.animation.LayoutTransition;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
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
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.12;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.22;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.23;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.26;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class avnl
  extends avnk
  implements View.OnClickListener
{
  static final int[] jdField_a_of_type_ArrayOfInt = { 2131376126, 2131376122, 2131376121, 2131376127, 2131376124, 2131376125, 2131376123 };
  int jdField_a_of_type_Int;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new avod(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aoim jdField_a_of_type_Aoim = new avnt(this);
  avju jdField_a_of_type_Avju;
  private avon jdField_a_of_type_Avon;
  private bayj jdField_a_of_type_Bayj = new avoc(this);
  NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private PicInfo jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo;
  public NearbyPeopleProfileActivity a;
  public BounceScrollView a;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  String jdField_a_of_type_JavaLangString = "";
  final ArrayList<PicInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList(13);
  public LinkedList<PicInfo> a;
  public final avau[] a;
  int jdField_b_of_type_Int = 2015;
  View jdField_b_of_type_AndroidViewView;
  EditText jdField_b_of_type_AndroidWidgetEditText;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private aoim jdField_b_of_type_Aoim = new avnu(this);
  final ArrayList<PicInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList(13);
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  EditText jdField_c_of_type_AndroidWidgetEditText;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private aoim jdField_c_of_type_Aoim = new avoe(this);
  int jdField_d_of_type_Int;
  EditText jdField_d_of_type_AndroidWidgetEditText;
  LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  int jdField_e_of_type_Int;
  EditText jdField_e_of_type_AndroidWidgetEditText;
  LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  int jdField_f_of_type_Int;
  EditText jdField_f_of_type_AndroidWidgetEditText;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  int jdField_g_of_type_Int;
  EditText jdField_g_of_type_AndroidWidgetEditText;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  int jdField_h_of_type_Int;
  EditText jdField_h_of_type_AndroidWidgetEditText;
  public TextView h;
  private int i;
  
  public avnl(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_Avon = new avon(this, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f);
    }
    this.jdField_h_of_type_Int = xsm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2.0F);
    int k = avju.jdField_a_of_type_ArrayOfInt.length - 1;
    this.jdField_a_of_type_ArrayOfAvau = new avau[k];
    int j = 0;
    while (j < k)
    {
      this.jdField_a_of_type_ArrayOfAvau[j] = new avau(avju.jdField_a_of_type_ArrayOfInt[j]);
      j += 1;
    }
    this.jdField_a_of_type_Bayj.addFilter(new Class[] { bavb.class });
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().a(this.jdField_a_of_type_Bayj);
  }
  
  private View.OnClickListener a(int paramInt)
  {
    return new avoj(this, paramInt);
  }
  
  @TargetApi(11)
  private RelativeLayout a(PicInfo paramPicInfo, Drawable paramDrawable)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.setBackgroundResource(2130844654);
    Object localObject = new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f);
    ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, this.jdField_h_of_type_Int, 0);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((CustomImgView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    a((CustomImgView)localObject, paramPicInfo, paramDrawable);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localRelativeLayout.setOnDragListener(this.jdField_a_of_type_Avon);
    }
    localRelativeLayout.addView((View)localObject);
    localRelativeLayout.addView(b());
    localRelativeLayout.setTag(paramPicInfo);
    return localRelativeLayout;
  }
  
  private void a(View paramView1, View paramView2)
  {
    paramView2.postDelayed(new NearbyProfileEditPanel.26(this, paramView2, paramView1), 300L);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int j = 2131166897;; j = 2131166903)
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
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Ayec == null) {
        break label208;
      }
    }
    label208:
    for (paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Ayec.a(localRichStatus.actionId, 200);; paramArrayOfByte = bdal.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130849040))
    {
      paramArrayOfByte = new bevq(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
      int j = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
      paramArrayOfByte.setBounds(0, 0, j, j);
      paramArrayOfByte = new beri(paramArrayOfByte, 0);
      paramArrayOfByte.a(-0.1F);
      ((SpannableStringBuilder)localObject).setSpan(paramArrayOfByte, 0, "[S]".length(), 17);
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    label225:
    paramTextView.setText((CharSequence)localObject);
  }
  
  private void a(PicInfo paramPicInfo, View paramView)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramPicInfo);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.remove(paramPicInfo);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(paramView);
      k();
      m();
      return;
    }
    paramPicInfo = bdgm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, alud.a(2131707724), 0, 0, null, null);
    paramPicInfo.setPositiveButton(2131694953, new avom(this, paramPicInfo));
    paramPicInfo.show();
  }
  
  private void a(CustomImgView paramCustomImgView, PicInfo paramPicInfo, Drawable paramDrawable)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      QLog.d("Q.nearby_people_card.", 2, "setDrawable, pos:" + this.jdField_a_of_type_AndroidWidgetLinearLayout.indexOfChild(paramCustomImgView) + ",picInfo:" + paramPicInfo);
    }
    paramCustomImgView.setTag(paramPicInfo);
    Object localObject = paramDrawable;
    if (paramDrawable == null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130845300);
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
        paramCustomImgView.setImageDrawable(URLDrawable.getDrawable(paramPicInfo, localURLDrawableOptions));
        return;
      }
      paramDrawable = null;
      if (TextUtils.isEmpty(paramPicInfo.b)) {
        break label258;
      }
      paramDrawable = paramPicInfo.b;
    }
    catch (MalformedURLException paramCustomImgView)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      while (QLog.isColorLevel())
      {
        paramPicInfo = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
        QLog.d("Q.nearby_people_card.", 2, "GridAdapter.getView() new URL(). " + paramCustomImgView.getMessage(), paramCustomImgView);
        return;
        if (!TextUtils.isEmpty(paramPicInfo.jdField_a_of_type_JavaLangString)) {
          paramDrawable = paramPicInfo.jdField_a_of_type_JavaLangString;
        }
      }
    }
    if (!TextUtils.isEmpty(paramDrawable))
    {
      paramCustomImgView.setImageDrawable(URLDrawable.getDrawable(bauz.a(paramDrawable), localURLDrawableOptions));
      return;
    }
    label258:
  }
  
  private View b()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localRelativeLayout.setBackgroundResource(2130841093);
    Object localObject = new RelativeLayout.LayoutParams(xsm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 35.0F), xsm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 16.0F));
    int j = xsm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 5.0F);
    ((RelativeLayout.LayoutParams)localObject).setMargins(j, 0, 0, j);
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    ((TextView)localObject).setText(alud.a(2131707743));
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
  
  private boolean d()
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
      if (((PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_Int != ((PicInfo)this.jdField_b_of_type_JavaUtilArrayList.get(j)).jdField_a_of_type_Int) {
        return true;
      }
      j += 1;
    }
    return false;
  }
  
  private boolean e()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (!bdnn.a(str))
    {
      if (bdnn.d(str).length() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(alud.a(2131707662));
        return false;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(alud.a(2131707675));
      return false;
    }
    return true;
  }
  
  private void j()
  {
    bhuf localbhuf = bhuf.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    Object localObject = (DispatchActionMoveScrollView)localbhuf.findViewById(2131361924);
    ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    localObject = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2131561005, null);
    ((IphonePickerView)localObject).a(this.jdField_b_of_type_Aoim);
    if (this.jdField_h_of_type_AndroidWidgetEditText.getTag() != null)
    {
      int k = (byte)(((Byte)this.jdField_h_of_type_AndroidWidgetEditText.getTag()).byteValue() - 1);
      int j;
      if (k >= 0)
      {
        j = k;
        if (k <= 3) {}
      }
      else
      {
        j = 0;
      }
      ((IphonePickerView)localObject).setSelection(0, j);
      ((IphonePickerView)localObject).setPickListener(new avoh(this, (IphonePickerView)localObject, localbhuf));
      localbhuf.a(new avoi(this));
      localbhuf.a((View)localObject, null);
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.isFinishing()) {}
    }
    else
    {
      return;
    }
    localbhuf.show();
    a(this.jdField_e_of_type_AndroidWidgetLinearLayout, localbhuf.a());
    a(this.jdField_h_of_type_AndroidWidgetEditText, true);
  }
  
  private void k()
  {
    l();
    int j = 0;
    if (j < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      Object localObject;
      if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j) instanceof RelativeLayout))
      {
        localObject = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
        ((RelativeLayout)localObject).setOnClickListener(a(j));
        if (((RelativeLayout)localObject).getChildCount() == 2) {
          if (j == 0)
          {
            ((RelativeLayout)localObject).getChildAt(1).setVisibility(0);
            label73:
            if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j) != null) {
              this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setContentDescription(alud.a(2131707653) + (j + 1));
            }
          }
        }
      }
      for (;;)
      {
        j += 1;
        break;
        ((RelativeLayout)localObject).getChildAt(1).setVisibility(8);
        break label73;
        if (QLog.isColorLevel())
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
          QLog.e("Q.nearby_people_card.", 2, "updatePhotoStatus, headItem's child count is not 2");
          continue;
          if (QLog.isColorLevel())
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
            QLog.e("Q.nearby_people_card.", 2, "updatePhotoStatus, the child of mEditLayout is not a instance of RelativeLayout");
          }
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaUtilArrayList.size() + "/" + NearbyPeopleProfileActivity.jdField_c_of_type_Int);
      return;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int j = 0;
    while (j < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      this.jdField_a_of_type_JavaUtilArrayList.add((PicInfo)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).getTag());
      j += 1;
    }
    if (QLog.isColorLevel())
    {
      NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      QLog.d("Q.nearby_people_card.", 2, "reorganizePicInfo:" + this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  private void m()
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "del_pho", 0, 0, "", "", "", "");
  }
  
  private void n()
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "up_gif", 0, 0, "", "", "", "");
  }
  
  private void o()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694754, new Object[] { this.jdField_a_of_type_JavaLangString });
      localObject = bdgm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
      ((bdjz)localObject).setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131695132), new avol(this, (bdjz)localObject));
      ((bdjz)localObject).show();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) && (QLog.isColorLevel())) {
        QLog.d("NearbyProfileEditPanel", 2, "mcard is null");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.g();
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131707682));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131707643));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 10.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131368624).setVisibility(8);
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368626);
    localTextView.setVisibility(0);
    localTextView.setText(2131690648);
    localTextView.setOnClickListener(new avnv(this));
    localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368655);
    localTextView.setVisibility(0);
    localTextView.setText(2131692682);
    localTextView.setEnabled(true);
    localTextView.setOnClickListener(new avnx(this));
    this.jdField_b_of_type_AndroidViewView.findViewById(2131375863).setOnClickListener(this);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      Object localObject = new StringBuilder(alud.a(2131707671));
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int - this.jdField_a_of_type_JavaUtilLinkedList.size() + 1).append("/").append(this.jdField_a_of_type_Int).append(")...");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(((StringBuilder)localObject).toString());
      localObject = new NearbyProfileEditPanel.22(this);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a((Runnable)localObject);
      return;
    }
    g();
  }
  
  protected int a()
  {
    return 2131561084;
  }
  
  Intent a(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, PhotoCropActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    paramString = alof.aX + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", paramString + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.QZONE_COVER_CROP_LEFT_TITLE", alud.a(2131707676));
    localIntent.putExtra("FROM_WHERE", "FROM_NEARBY_PROFILE");
    return localIntent;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().b(this.jdField_a_of_type_Bayj);
  }
  
  public void a(int paramInt)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", NearbyPeopleProfileActivity.jdField_c_of_type_Int - paramInt);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    String str = alof.aX + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    localIntent.putExtra("enter_from", 30);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(localIntent);
    bdfa.anim(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, false, true);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800481F", "0X800481F", 1, 0, "", "", "", "");
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
    localObject1 = bdeu.a(paramInt2 + 1, paramInt3 + 1);
    paramInt2 = AgeSelectionActivity.a((String)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramInt1).append("-").append(j).append("-").append(m).append(" ").append("(").append(k).append("岁").append(" ").append((String)localObject1).append(")");
    this.jdField_c_of_type_AndroidWidgetEditText.setText(((StringBuilder)localObject2).toString());
    this.jdField_c_of_type_AndroidWidgetEditText.setTag(new Object[] { Integer.valueOf(paramInt1 << 16 | j << 8 | m), Integer.valueOf(k), Integer.valueOf(paramInt2) });
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    switch (paramInt1)
    {
    }
    label406:
    label413:
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
            if (this.jdField_g_of_type_AndroidWidgetEditText != null)
            {
              a(this.jdField_g_of_type_AndroidWidgetEditText, paramIntent);
              this.jdField_g_of_type_AndroidWidgetEditText.setTag(paramIntent);
              return;
              if ((paramInt2 == -1) && (paramIntent != null))
              {
                Object localObject1 = paramIntent.getStringExtra("key_cover_selected_img_path");
                this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("key_album_id");
                if (!bdnn.a((String)localObject1))
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
                      if ((paramInt2 == -1) && (paramIntent != null))
                      {
                        Object localObject2;
                        for (;;)
                        {
                          try
                          {
                            localObject2 = paramIntent.getParcelableArrayListExtra("choosed_interest_tags");
                            paramInt2 = paramIntent.getIntExtra("interest_tag_type", -1);
                            paramInt1 = j;
                            if (paramInt1 < this.jdField_a_of_type_ArrayOfAvau.length)
                            {
                              if (this.jdField_a_of_type_ArrayOfAvau[paramInt1].jdField_a_of_type_Int != paramInt2) {
                                break label406;
                              }
                              paramIntent = this.jdField_a_of_type_ArrayOfAvau[paramInt1];
                              paramIntent.jdField_a_of_type_JavaUtilArrayList.clear();
                              if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
                                paramIntent.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject2);
                              }
                            }
                            this.jdField_a_of_type_Avju.a(this.jdField_a_of_type_ArrayOfAvau);
                            if (!QLog.isDevelopLevel()) {
                              break;
                            }
                            localObject1 = new StringBuilder().append("doOnActivity result code :11 ");
                            if (localObject2 != null) {
                              break label413;
                            }
                            paramIntent = "";
                            QLog.i("Q.nearby_people_card.", 4, paramIntent + " " + paramInt2);
                            return;
                          }
                          catch (Exception paramIntent) {}
                          if (!QLog.isColorLevel()) {
                            break;
                          }
                          QLog.i("Q.nearby_people_card.", 2, paramIntent.getMessage());
                          return;
                          paramInt1 += 1;
                          continue;
                          paramIntent = localObject2.toString();
                        }
                        if ((paramInt2 == -1) && (this.jdField_d_of_type_AndroidWidgetEditText != null))
                        {
                          localObject1 = paramIntent.getStringExtra("param_name");
                          paramInt1 = paramIntent.getIntExtra("param_id", -1);
                          localObject2 = paramIntent.getStringExtra("param_tag");
                          paramInt2 = paramIntent.getIntExtra("param_tag_bg", -1);
                          if ((localObject2 != null) && (((String)localObject2).length() > 0) && (paramInt2 > 0))
                          {
                            this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
                            this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(paramInt2);
                            this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
                          }
                          for (;;)
                          {
                            this.jdField_d_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
                            this.jdField_d_of_type_AndroidWidgetEditText.setTag(Integer.valueOf(paramInt1));
                            return;
                            this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
                          }
                          if (paramInt2 == -1)
                          {
                            localObject2 = paramIntent.getStringArrayExtra("param_location");
                            try
                            {
                              paramIntent = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Alpy.a((String[])localObject2);
                              if (paramIntent != null)
                              {
                                localObject1 = paramIntent;
                                if (!paramIntent.equals("不限")) {}
                              }
                              else
                              {
                                localObject1 = "";
                              }
                              if (this.jdField_f_of_type_AndroidWidgetEditText != null)
                              {
                                this.jdField_f_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
                                this.jdField_f_of_type_AndroidWidgetEditText.setTag(localObject2);
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
    k();
  }
  
  protected void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
    paramView.findViewById(2131377989).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378029));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377968));
    paramView.findViewById(2131368670).setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131365594));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131166961));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)paramView.findViewById(2131365595));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131365575));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams().height = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.f;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams());
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371825));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377195));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131365592));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131365593));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377013));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131371161));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131367113));
    this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131362209));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364014));
    this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131368989));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131368990));
    this.jdField_e_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131364651));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364430));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364429));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364037));
    this.jdField_f_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131367702));
    this.jdField_g_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131380358));
    this.jdField_h_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131377008));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131366609));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376120));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramView.findViewById(2131378030));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365599));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.mScrollFlag = 1;
    paramView = (LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131369120);
    this.jdField_a_of_type_Avju = new avju();
    this.jdField_a_of_type_Avju.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramView);
    p();
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    Object localObject;
    int j;
    label268:
    label295:
    label587:
    label733:
    boolean bool;
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
      j = ((Integer)auwq.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "exp_edit", 0, 0, auwz.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_j_of_type_Int), j + "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
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
        break label1208;
      }
      this.jdField_a_of_type_JavaLangString = alud.a(2131707672);
      if (!this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) {
        break label1232;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694720));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(alud.a(2131707636));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new avnn(this));
      e();
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      this.jdField_b_of_type_AndroidWidgetEditText.setText(bdda.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender));
      this.jdField_b_of_type_AndroidWidgetEditText.setTag(Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender));
      j = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age;
      int k = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday;
      int m = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation;
      int n = (0xFF00 & k) >> 8;
      int i1 = k & 0xFF;
      paramNearbyPeopleCard = bdeu.a(n, i1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(k >> 16).append("-").append(n).append("-").append(i1).append(" ").append("(").append(j).append("岁").append(" ").append(paramNearbyPeopleCard).append(")");
      this.jdField_c_of_type_AndroidWidgetEditText.setText(((StringBuilder)localObject).toString());
      this.jdField_c_of_type_AndroidWidgetEditText.setTag(new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(m) });
      j = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(bdda.d(j));
      if (!bdnn.a(bdda.d(j))) {
        break label1276;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetEditText.setText(bdda.e(j));
      this.jdField_d_of_type_AndroidWidgetEditText.setTag(Integer.valueOf(j));
      this.jdField_e_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company);
      this.jdField_e_of_type_AndroidWidgetEditText.clearFocus();
      paramNearbyPeopleCard = (String)auwq.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "school_name", "");
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
        if (!TextUtils.equals(paramNearbyPeopleCard, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college)) {
          break label1310;
        }
        this.i = ((Integer)auwq.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "school_valid_state", Integer.valueOf(0))).intValue();
        if (this.i != 2) {
          break label1298;
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      d();
      a(this.jdField_g_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
      this.jdField_g_of_type_AndroidWidgetEditText.setTag(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
      this.jdField_h_of_type_AndroidWidgetEditText.setText(bdda.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1));
      this.jdField_h_of_type_AndroidWidgetEditText.setTag(Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus));
      if (bdda.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.vGiftInfo) == 0) {
        break label1439;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible != 0L) {
        break label1433;
      }
      bool = true;
      label846:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag)
      {
        paramNearbyPeopleCard = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694755, new Object[] { this.jdField_a_of_type_JavaLangString });
        paramNearbyPeopleCard = bdgm.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramNearbyPeopleCard, 0, 0, null, null);
        paramNearbyPeopleCard.setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131695132), new avno(this, paramNearbyPeopleCard));
        paramNearbyPeopleCard.show();
      }
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getTagInfos(this.jdField_a_of_type_ArrayOfAvau);
      this.jdField_a_of_type_Avju.a(this.jdField_a_of_type_ArrayOfAvau);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_j_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.k == 1)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new NearbyProfileEditPanel.12(this), 300L);
      }
      this.jdField_b_of_type_AndroidViewView.findViewById(2131380359).setOnClickListener(this);
      this.jdField_g_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131377013).setOnClickListener(this);
      this.jdField_h_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131367116).setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131362211).setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131368990).setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131367703).setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new avnp(this));
      this.jdField_g_of_type_AndroidWidgetEditText.addTextChangedListener(new avnq(this));
      this.jdField_e_of_type_AndroidWidgetEditText.addTextChangedListener(new avnr(this));
      this.jdField_a_of_type_AndroidWidgetEditText.getViewTreeObserver().addOnGlobalLayoutListener(new avns(this));
      return;
      localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size());
      break;
      label1208:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender != 1) {
        break label268;
      }
      this.jdField_a_of_type_JavaLangString = alud.a(2131707727);
      break label268;
      label1232:
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= NearbyPeopleProfileActivity.jdField_b_of_type_Int) {
        break label295;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694721, new Object[] { this.jdField_a_of_type_JavaLangString }));
      break label295;
      label1276:
      this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(bdda.b(j));
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      break label587;
      label1298:
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      break label733;
      label1310:
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.collegeId == 0L) {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college))
        {
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
          this.i = 1;
        }
      }
      for (;;)
      {
        auwq.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "school_name", this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
        auwq.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "school_valid_state", Integer.valueOf(this.i));
        break;
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        this.i = 2;
        continue;
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
        this.i = 1;
      }
      label1433:
      bool = false;
      break label846;
      label1439:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
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
      this.jdField_f_of_type_AndroidWidgetTextView.setText("");
      paramInt = 0;
      if (paramInt != 0)
      {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8006784", "0X8006784", 0, 0, "", "", "", "");
      }
    }
    else
    {
      if (paramInt == 0)
      {
        if (TextUtils.equals(this.jdField_f_of_type_AndroidWidgetTextView.getText().toString(), paramString)) {
          if (this.i == 2) {
            paramInt = j;
          }
        }
        for (;;)
        {
          this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
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
    this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_c_of_type_Boolean) {
      return true;
    }
    if (d()) {
      return true;
    }
    int j;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag())) {
        return true;
      }
      if (!bdeu.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname)) {
        return true;
      }
      if ((this.jdField_h_of_type_AndroidWidgetEditText.getTag() != null) && (((Byte)this.jdField_h_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus)) {
        return true;
      }
      if (((Byte)this.jdField_b_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender) {
        return true;
      }
      if (((Integer)((Object[])(Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag())[0]).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday) {
        return true;
      }
      if (((Integer)this.jdField_d_of_type_AndroidWidgetEditText.getTag()).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job) {
        return true;
      }
      if (!bdnn.d(this.jdField_e_of_type_AndroidWidgetEditText.getText().toString()).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company)) {
        return true;
      }
      if (!bdnn.d(this.jdField_f_of_type_AndroidWidgetTextView.getText().toString()).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college)) {
        return true;
      }
      if (!Arrays.equals((String[])this.jdField_f_of_type_AndroidWidgetEditText.getTag(), new String[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict })) {
        return true;
      }
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible == 0L) {}
      for (boolean bool1 = true; bool2 != bool1; bool1 = false) {
        return true;
      }
      Object localObject2 = this.jdField_a_of_type_ArrayOfAvau;
      int m = localObject2.length;
      k = 0;
      j = 0;
      if (k >= m) {
        break label561;
      }
      StringBuilder localStringBuilder = localObject2[k];
      if (localStringBuilder == null) {}
      do
      {
        k += 1;
        break;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.getTagInfos(localStringBuilder.jdField_a_of_type_Int);
      } while ((localObject1 == null) && (localStringBuilder.jdField_a_of_type_JavaUtilArrayList.size() == 0));
      if (!localStringBuilder.equals(localObject1))
      {
        j = 1;
        label440:
        if (j == 0) {
          break label558;
        }
        k = j;
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          localStringBuilder = ((StringBuilder)localObject2).append("tagChanged \n").append("item: ").append(localStringBuilder.toString()).append("\n").append("tag: ");
          if (localObject1 != null) {
            break label546;
          }
          localObject1 = "null";
          label507:
          localStringBuilder.append((String)localObject1).append("\n");
          QLog.i("InterestTag", 4, ((StringBuilder)localObject2).toString());
        }
      }
    }
    label546:
    label558:
    label561:
    for (int k = j;; k = j)
    {
      if (k != 0)
      {
        return true;
        j = 0;
        break label440;
        localObject1 = ((avau)localObject1).toString();
        break label507;
      }
      return false;
      break;
    }
  }
  
  public boolean a(PicInfo paramPicInfo)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a(paramPicInfo, null), this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount());
    k();
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
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.fullScroll(66);
  }
  
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
    alpy localalpy = (alpy)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(59);
    int j = localalpy.a();
    Object localObject1;
    if (j != 0)
    {
      j = localalpy.a(j, true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "startLocationSelectActivity | update result = " + j);
      }
      if (j == 2)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131694768, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
        return;
      }
      if (j == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131691085));
        localalpy.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Alqc);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131691085));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      ((Handler)localObject1).sendEmptyMessageDelayed(206, 20000L);
      return;
    }
    Object localObject2 = (String[])this.jdField_f_of_type_AndroidWidgetEditText.getTag();
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
    localIntent.putExtra("param_location_param", localalpy.b((String[])localObject1));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 4);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_c_of_type_Boolean) {
      return true;
    }
    if (d()) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag())) {
        return true;
      }
      if (!bdeu.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname)) {
        return true;
      }
    }
    return false;
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
      str = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Alpy.a(arrayOfString);
    } while (this.jdField_f_of_type_AndroidWidgetEditText == null);
    if (!"不限".equals(str)) {
      this.jdField_f_of_type_AndroidWidgetEditText.setText(str);
    }
    this.jdField_f_of_type_AndroidWidgetEditText.setTag(arrayOfString);
  }
  
  @TargetApi(11)
  void e()
  {
    int j = 0;
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_JavaUtilArrayList.size() == 0);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.oldPhotoCount > 0) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age >= 14) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age <= 24) && (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1)) {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800481B", "0X800481B", 0, 0, "", "", "", "");
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      LayoutTransition localLayoutTransition = new LayoutTransition();
      localLayoutTransition.setAnimator(2, null);
      if (Build.VERSION.SDK_INT <= 15)
      {
        localLayoutTransition.setAnimator(0, null);
        localLayoutTransition.setAnimator(1, null);
        localLayoutTransition.setAnimator(3, null);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutTransition(localLayoutTransition);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a((PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j), null));
      j += 1;
    }
    k();
  }
  
  void f()
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004823", "0X8004823", 0, 0, "", "", "", "");
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "doOldSaveAction, picInfo size|" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    q();
  }
  
  void g()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "saveNearbyProfileCard");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(alud.a(2131707719));
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    if (d())
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 10, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e != 1) {
        break label1305;
      }
    }
    label1158:
    label1288:
    label1305:
    for (int j = 1;; j = 3)
    {
      Object localObject;
      boolean bool1;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 0))
      {
        localObject = "1";
        azqs.b(null, "dc00899", "grp_lbs", "", "data_card", "upload_video", 0, 0, "", (String)localObject, "", String.valueOf(j));
        j = ((Integer)auwq.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "suc_edit", 0, 0, auwz.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_j_of_type_Int), j + "", "", "");
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("key_is_nearby_people_card", true);
        localBundle.putShort("key_new_profile_modified_flag", (short)1);
        if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
        {
          byte[] arrayOfByte = (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag();
          localObject = arrayOfByte;
          if (arrayOfByte == null) {
            localObject = new byte[0];
          }
          localBundle.putByteArray("key_xuan_yan", (byte[])localObject);
          if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag()))
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d = true;
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 2, 0, "", "", "", "");
          }
          localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
          if (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname))
          {
            localBundle.putString("key_new_nickname", (String)localObject);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d = true;
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 1, 0, "", "", "", "");
          }
          if ((this.jdField_h_of_type_AndroidWidgetEditText.getTag() != null) && (((Byte)this.jdField_h_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus))
          {
            localBundle.putByte("key_marital_status", ((Byte)this.jdField_h_of_type_AndroidWidgetEditText.getTag()).byteValue());
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 3, 0, "", "", "", "");
          }
          byte b1 = ((Byte)this.jdField_b_of_type_AndroidWidgetEditText.getTag()).byteValue();
          if (b1 != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender)
          {
            localBundle.putByte("sex", b1);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d = true;
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 4, 0, "", "", "", "");
          }
          localObject = (Object[])this.jdField_c_of_type_AndroidWidgetEditText.getTag();
          j = ((Integer)localObject[0]).intValue();
          if (j != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday)
          {
            localBundle.putInt("birthday", j);
            localBundle.putInt("age", ((Integer)localObject[1]).intValue());
            localBundle.putInt("key_constellation", ((Integer)localObject[2]).intValue());
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 5, 0, "", "", "", "");
          }
          j = ((Integer)this.jdField_d_of_type_AndroidWidgetEditText.getTag()).intValue();
          if (j != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job)
          {
            localBundle.putInt("profession", j);
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 6, 0, "", "", "", "");
          }
          localObject = this.jdField_e_of_type_AndroidWidgetEditText.getText().toString();
          if (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company))
          {
            localBundle.putString("company", (String)localObject);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d = true;
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 7, 0, "", "", "", "");
          }
          localObject = this.jdField_f_of_type_AndroidWidgetTextView.getText().toString();
          if (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college))
          {
            localBundle.putString("college", (String)localObject);
            this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d = true;
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 8, 0, "", "", "", "");
          }
          localObject = (String[])this.jdField_f_of_type_AndroidWidgetEditText.getTag();
          if (!Arrays.equals((Object[])localObject, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict }))
          {
            localBundle.putStringArray("hometown", (String[])localObject);
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 9, 0, "", "", "", "");
          }
          boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
          if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchGiftVisible != 0L) {
            break label1242;
          }
          bool1 = true;
          label1097:
          if (bool2 != bool1)
          {
            if (!bool2) {
              break label1247;
            }
            j = 0;
            label1110:
            localBundle.putShort("key_flower_visible_switch", (short)j);
            if (!bool2) {
              break label1252;
            }
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80060BB", "0X80060BB", 0, 0, "", "", "", "");
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby_people_card.update_profile", 2, "Q.nearby_people_card..saveNearbyProfileCard, modified_data = " + localBundle.toString());
          }
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Auxh;
        if (localObject == null) {
          break label1288;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a(new NearbyProfileEditPanel.23(this, (auxh)localObject, localBundle, localArrayList));
      }
      label1242:
      label1247:
      label1252:
      while (!QLog.isDevelopLevel())
      {
        return;
        localObject = "2";
        break;
        bool1 = false;
        break label1097;
        j = 1;
        break label1110;
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X80060BC", "0X80060BC", 0, 0, "", "", "", "");
        break label1158;
      }
      QLog.i("Q.nearby_people_card.", 4, "NearbyCardHandler is null");
      return;
    }
  }
  
  public void h()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, JobSelectionActivity.class);
    if ((this.jdField_d_of_type_AndroidWidgetEditText != null) && (this.jdField_d_of_type_AndroidWidgetEditText.getTag() != null) && ((this.jdField_d_of_type_AndroidWidgetEditText.getTag() instanceof Integer))) {
      localIntent.putExtra("param_id", (Integer)this.jdField_d_of_type_AndroidWidgetEditText.getTag());
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 3);
  }
  
  public void i()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, EditActivity.class);
    localIntent.putExtra("param_entry", 1);
    localIntent.putExtra("param_old_xuan_yan", (byte[])this.jdField_g_of_type_AndroidWidgetEditText.getTag());
    localIntent.putExtra("max_word_count", 30);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 1);
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    int k;
    if ((paramView.getId() == 2131367116) || (paramView == this.jdField_b_of_type_AndroidWidgetEditText))
    {
      localObject1 = bhuf.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      localObject2 = (DispatchActionMoveScrollView)((bhuf)localObject1).findViewById(2131361924);
      ((DispatchActionMoveScrollView)localObject2).jdField_a_of_type_Boolean = true;
      ((DispatchActionMoveScrollView)localObject2).setBackgroundResource(17170445);
      localObject2 = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2131561005, null);
      ((IphonePickerView)localObject2).a(this.jdField_c_of_type_Aoim);
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
        ((IphonePickerView)localObject2).setPickListener(new avnm(this, (IphonePickerView)localObject2, (bhuf)localObject1));
        ((bhuf)localObject1).a(new avnw(this));
        ((bhuf)localObject1).a((View)localObject2, null);
        ((bhuf)localObject1).show();
        a(paramView, ((bhuf)localObject1).a());
        a(this.jdField_b_of_type_AndroidWidgetEditText, true);
      }
    }
    Object localObject3;
    do
    {
      do
      {
        return;
        if ((paramView.getId() == 2131368990) || (paramView == this.jdField_d_of_type_AndroidWidgetEditText))
        {
          h();
          return;
        }
        if (paramView == this.jdField_d_of_type_AndroidWidgetLinearLayout)
        {
          paramView = this.jdField_f_of_type_AndroidWidgetTextView.getText().toString();
          paramView = bhsz.a(bhsz.a(bhsz.a(bhsz.a("https://qun.qq.com/qqweb/m/nearby/pages/school_edit.html", "_bid", "2473"), "_wv", "1031"), "schoolName", paramView), "isValid", String.valueOf(this.i));
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramView);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject1);
          return;
        }
        if ((paramView.getId() == 2131367703) || (paramView == this.jdField_f_of_type_AndroidWidgetEditText))
        {
          c();
          return;
        }
        if ((paramView.getId() == 2131380359) || (paramView == this.jdField_g_of_type_AndroidWidgetEditText))
        {
          i();
          return;
        }
        if ((paramView.getId() == 2131377013) || (paramView == this.jdField_h_of_type_AndroidWidgetEditText))
        {
          j();
          return;
        }
      } while ((paramView.getId() != 2131362211) && (paramView != this.jdField_c_of_type_AndroidWidgetEditText));
      localObject1 = bhuf.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      localObject2 = Calendar.getInstance();
      this.jdField_b_of_type_Int = ((Calendar)localObject2).get(1);
      localObject3 = (DispatchActionMoveScrollView)((bhuf)localObject1).findViewById(2131361924);
      ((DispatchActionMoveScrollView)localObject3).jdField_a_of_type_Boolean = true;
      ((DispatchActionMoveScrollView)localObject3).setBackgroundResource(17170445);
      localObject3 = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2131561005, null);
      ((IphonePickerView)localObject3).a(this.jdField_a_of_type_Aoim);
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
      ((IphonePickerView)localObject3).setPickListener(new avof(this, (IphonePickerView)localObject3, (bhuf)localObject1));
      ((IphonePickerView)localObject3).setSelection(0, m);
      ((IphonePickerView)localObject3).setSelection(1, k);
      ((IphonePickerView)localObject3).setSelection(2, j);
      ((bhuf)localObject1).a(new avog(this));
      ((bhuf)localObject1).a((View)localObject3, null);
      ((bhuf)localObject1).show();
      a(paramView, ((bhuf)localObject1).a());
      a(this.jdField_c_of_type_AndroidWidgetEditText, true);
      return;
      m = (j >>> 16) - 1896;
      k = ((0xFF00 & j) >>> 8) - 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avnl
 * JD-Core Version:    0.7.0.1
 */