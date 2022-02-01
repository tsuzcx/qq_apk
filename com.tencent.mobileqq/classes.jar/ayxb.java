import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ayxb
  extends ayrs
{
  View.OnClickListener a;
  
  public ayxb(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ayxc(this);
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null) {
      return false;
    }
    if (((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", "", "0X800A1C6", "0X800A1C6", 0, 0, "", "", "", "");
      QZLog.d("cardInfo.allinone.pa", 2, new Object[] { Integer.valueOf(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a) });
      if ((paramCard.presentSwitch) && (!ProfileActivity.AllInOne.f(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
        break label152;
      }
      if (this.jdField_a_of_type_JavaLangObject == null) {
        break label147;
      }
    }
    label147:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_JavaLangObject = null;
      return paramBoolean;
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", "", "0X800A1C8", "0X800A1C8", 0, 0, "", "", "", "");
      break;
    }
    label152:
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561348, null);
    this.jdField_a_of_type_JavaLangObject = localView;
    Object localObject1 = (ViewGroup)localView.findViewById(2131368689);
    TextView localTextView = (TextView)localView.findViewById(2131378524);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131368384);
    Object localObject2 = (ImageView)localView.findViewById(2131368690);
    Object localObject3 = (ImageView)localView.findViewById(2131368691);
    Object localObject4 = (ImageView)localView.findViewById(2131368692);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131368693);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject2);
    localArrayList.add(localObject3);
    localArrayList.add(localObject4);
    localArrayList.add(localImageView2);
    localTextView.setSingleLine(true);
    localTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    int i;
    int j;
    int k;
    if ((paramCard.showPresent) && (paramCard.presentUrl != null))
    {
      ((ViewGroup)localObject1).setVisibility(0);
      localObject2 = paramCard.presentUrl;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      i = ((Resources)localObject1).getDimensionPixelSize(2131298337);
      j = ((Resources)localObject1).getDimensionPixelSize(2131297537);
      k = ((Resources)localObject1).getDimensionPixelSize(2131297534);
      localObject1 = ((Resources)localObject1).getDisplayMetrics();
      j = (int)(Math.min(((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels) - j - k);
      k = (int)((j - i * 3 * 1.0F) / 3.0F);
      if (QLog.isColorLevel()) {
        QLog.e("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "makeOrRefreshQZone count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(localArrayList.size()), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) }));
      }
      localObject1 = null;
      if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
        if (((List)localObject2).size() > 4)
        {
          i = 4;
          j = 0;
          label523:
          if (j >= i) {
            break label705;
          }
          localObject3 = (String)((List)localObject2).get(j);
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label872;
          }
          if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            ((ImageView)localArrayList.get(j)).setColorFilter(1996488704);
          }
          if (localObject1 != null) {
            break label869;
          }
          localObject1 = new ColorDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131165720));
        }
      }
    }
    label705:
    label863:
    label869:
    label872:
    for (;;)
    {
      try
      {
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = k;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = k;
        localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
        ((ImageView)localArrayList.get(j)).setImageDrawable((Drawable)localObject3);
        j += 1;
        break label523;
        i = ((List)localObject2).size();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.profilecard.FrdProfileCard", 2, "makeOrRefreshPresent fail!", localException);
        }
        continue;
      }
      if (((aymg)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0)
      {
        localObject1 = amtj.a(2131707575);
        if (TextUtils.isEmpty(paramCard.presentDesc)) {
          break label863;
        }
      }
      for (paramCard = ": " + paramCard.presentDesc;; paramCard = "")
      {
        localTextView.setText((String)localObject1 + amtj.a(2131707582) + paramCard);
        localView.setTag(new aykg(94, null));
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691063));
        a(localTextView, null, localImageView1);
        return true;
        localObject1 = ((aymg)this.b).jdField_a_of_type_ArrayOfJavaLangString[0];
        break;
      }
    }
  }
  
  public int a()
  {
    return 1018;
  }
  
  public String a()
  {
    return "ProfilePresentWallComponent";
  }
  
  public boolean a(aymg paramaymg)
  {
    boolean bool = super.a(paramaymg);
    return a(((aymg)this.b).jdField_a_of_type_ComTencentMobileqqDataCard, ((aymg)this.b).d) | bool;
  }
  
  public String a_()
  {
    return "map_key_present";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxb
 * JD-Core Version:    0.7.0.1
 */