import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.10;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.11;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.12;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class bbcm
  implements awei, bbbm<bazc, bbhi>
{
  public static int a;
  private long jdField_a_of_type_Long;
  public ColorDrawable a;
  public Drawable a;
  private baup jdField_a_of_type_Baup;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bbcm(FaceDecoder paramFaceDecoder, baup parambaup)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = URLDrawableHelper.TRANSPARENT;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_Baup = parambaup;
  }
  
  private float a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 7.0F;
    }
    return 3.5F;
  }
  
  private int a(bazs parambazs, bbib parambbib)
  {
    if ((parambazs == null) || (parambazs.jdField_a_of_type_Bazt == null) || (parambbib == null) || (parambbib.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      if ((parambbib != null) && (parambbib.jdField_a_of_type_AndroidWidgetButton != null)) {
        parambbib.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((parambbib != null) && (parambbib.jdField_a_of_type_AndroidWidgetImageView != null)) {
        parambbib.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    if (parambazs.jdField_a_of_type_Bazt.jdField_a_of_type_Int == 1)
    {
      if (parambbib.jdField_a_of_type_AndroidWidgetButton != null) {
        parambbib.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if (parambbib.jdField_a_of_type_AndroidWidgetImageView != null) {
        parambbib.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    Context localContext = parambbib.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext();
    int i;
    if (parambazs.jdField_a_of_type_Bazt.jdField_a_of_type_Int == 2)
    {
      if (parambbib.jdField_a_of_type_AndroidWidgetImageView != null) {
        parambbib.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (parambbib.jdField_a_of_type_AndroidWidgetButton == null) {
        return 0;
      }
      if (!TextUtils.isEmpty(parambazs.jdField_a_of_type_Bazt.jdField_a_of_type_JavaLangCharSequence))
      {
        parambbib.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        parambbib.jdField_a_of_type_AndroidWidgetButton.setText(parambazs.jdField_a_of_type_Bazt.jdField_a_of_type_JavaLangCharSequence);
        parambbib.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bbct(this, localContext, parambazs));
      }
      for (;;)
      {
        i = (int)(0 + (bbgk.a(parambbib.jdField_a_of_type_AndroidWidgetButton, parambazs.jdField_a_of_type_Bazt.jdField_a_of_type_JavaLangCharSequence) + DisplayUtil.dip2px(localContext, 32.0F) + DisplayUtil.dip2px(localContext, 15.0F)));
        if (!bool) {
          break;
        }
        parambbib.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843321);
        parambbib.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#6991B8"));
        return i;
        parambbib.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      parambbib.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843320);
      parambbib.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#000000"));
      return i;
    }
    int j;
    if (parambazs.jdField_a_of_type_Bazt.jdField_a_of_type_Int == 3)
    {
      if (parambbib.jdField_a_of_type_AndroidWidgetButton != null) {
        parambbib.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((parambbib.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (parambbib.jdField_a_of_type_AndroidWidgetImageView == null)) {
        return 0;
      }
      int k = ((Integer)parambbib.a().getTag(2131380832)).intValue();
      SongInfo localSongInfo1 = new SongInfo();
      i = 0;
      j = i;
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(parambazs.h);
          j = i;
          localSongInfo1.jdField_b_of_type_JavaLangString = localJSONObject.optString("audio_url");
          j = i;
          localSongInfo1.jdField_c_of_type_JavaLangString = localJSONObject.optString("title");
          j = i;
          localSongInfo1.d = localJSONObject.optString("desc");
          j = i;
          localSongInfo1.e = localJSONObject.optString("image_url");
          j = i;
          if (TextUtils.isEmpty(localJSONObject.optString("id"))) {
            continue;
          }
          i = 1;
          if (i != 0)
          {
            j = i;
            localSongInfo1.jdField_a_of_type_Long = Long.parseLong(localJSONObject.optString("id"));
          }
          j = i;
          int m = localJSONObject.optInt("playable");
          if (m != 1) {
            continue;
          }
          j = 1;
        }
        catch (Exception localException)
        {
          i = j;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, localException.toString());
          j = 0;
          continue;
          SongInfo localSongInfo2 = QQPlayerService.b();
          if (localSongInfo2 == null) {
            continue;
          }
          bbgk.jdField_a_of_type_Long = localSongInfo2.jdField_a_of_type_Long;
          continue;
          parambbib.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849548);
          continue;
          if (this.jdField_a_of_type_Long != bbgk.jdField_a_of_type_Long) {
            continue;
          }
          parambbib.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849549);
          continue;
          parambbib.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849547);
          continue;
          parambbib.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
        }
        this.jdField_a_of_type_Long = localSongInfo1.jdField_a_of_type_Long;
        QQPlayerService.a(this);
        if (QQPlayerService.a() == 2) {
          continue;
        }
        bbgk.jdField_a_of_type_Long = -1L;
        if (!bool) {
          continue;
        }
        if (this.jdField_a_of_type_Long != bbgk.jdField_a_of_type_Long) {
          continue;
        }
        parambbib.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849550);
        if ((j == 0) || (i == 0) || (TextUtils.isEmpty(localSongInfo1.jdField_b_of_type_JavaLangString))) {
          continue;
        }
        parambbib.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        parambbib.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bbcu(this, parambbib, k, localContext, bool, localSongInfo1, parambazs));
        return DisplayUtil.dip2px(localContext, 39.0F) + 0;
        i = 0;
        continue;
        j = 0;
      }
    }
    parambbib.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    return 0;
  }
  
  private int a(bazs parambazs, bbib parambbib, int paramInt1, int paramInt2)
  {
    if ((parambbib == null) || (parambazs == null) || (parambbib.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {
      return 0;
    }
    Context localContext = parambbib.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    int i = localContext.getResources().getDisplayMetrics().widthPixels - paramInt1 - paramInt2 - DisplayUtil.dip2px(localContext, 30.0F);
    if ((parambazs.jdField_a_of_type_JavaUtilArrayList != null) && (parambazs.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      parambbib.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if ((parambazs.jdField_a_of_type_Bazu != null) && (parambazs.jdField_a_of_type_JavaUtilArrayList != null) && (parambazs.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        parambbib.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (parambbib.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
          parambbib.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
        }
        if (parambazs.jdField_a_of_type_Bazu.jdField_a_of_type_Int == 1)
        {
          if (parambbib.jdField_b_of_type_AndroidWidgetTextView != null) {
            parambbib.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if ((parambbib.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(parambazs.jdField_a_of_type_Bazu.jdField_a_of_type_JavaLangString))) {
            break label1007;
          }
          parambbib.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          a(parambbib.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, parambazs.jdField_a_of_type_Bazu.jdField_a_of_type_JavaLangString);
          paramInt1 = i - DisplayUtil.dip2px(localContext, 24.0F);
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      if ((parambbib.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(((bazv)parambazs.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence)))
      {
        localObject1 = ((bazv)parambazs.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence;
        if (!((bazv)parambazs.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean) {
          break label635;
        }
        localObject1 = bbgk.a(parambbib.jdField_a_of_type_AndroidWidgetTextView, paramInt1, 1, ((CharSequence)localObject1).toString(), parambazs.jdField_a_of_type_Bbfz.jdField_a_of_type_JavaUtilList, false, false, true);
        label297:
        parambbib.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (parambbib.c != null) {
          break label677;
        }
        return parambbib.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
        if (parambazs.jdField_a_of_type_Bazu.jdField_a_of_type_Int == 2)
        {
          if (parambbib.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
            parambbib.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
          }
          if ((parambbib.jdField_b_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(parambazs.jdField_a_of_type_Bazu.jdField_a_of_type_JavaLangCharSequence))) {
            break label1007;
          }
          if (bbgk.e(parambazs.jdField_a_of_type_Bazu.jdField_b_of_type_JavaLangString)) {}
          for (localObject1 = parambazs.jdField_a_of_type_Bazu.jdField_b_of_type_JavaLangString;; localObject1 = "#fd7f32")
          {
            ((GradientDrawable)parambbib.jdField_b_of_type_AndroidWidgetTextView.getBackground()).setColor(Color.parseColor((String)localObject1));
            parambbib.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            parambbib.jdField_b_of_type_AndroidWidgetTextView.setText(parambazs.jdField_a_of_type_Bazu.jdField_a_of_type_JavaLangCharSequence);
            paramInt1 = (int)(i - (bbgk.a(parambbib.jdField_b_of_type_AndroidWidgetTextView, parambazs.jdField_a_of_type_Bazu.jdField_a_of_type_JavaLangCharSequence) + DisplayUtil.dip2px(localContext, 10.0F)));
            break;
          }
        }
        if (parambazs.jdField_a_of_type_Bazu.jdField_a_of_type_Int != 3) {
          break label1007;
        }
        if (parambbib.jdField_b_of_type_AndroidWidgetTextView != null) {
          parambbib.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if ((parambbib.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(parambazs.jdField_a_of_type_Bazu.jdField_a_of_type_JavaLangString))) {
          break label1007;
        }
        parambbib.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
        if ((parambazs.jdField_a_of_type_Bazu.jdField_b_of_type_Int > 0) && (parambazs.jdField_a_of_type_Bazu.jdField_c_of_type_Int > 0))
        {
          a(parambbib.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, parambazs.jdField_a_of_type_Bazu.jdField_b_of_type_Int, parambazs.jdField_a_of_type_Bazu.jdField_c_of_type_Int, parambazs.jdField_a_of_type_Bazu.jdField_a_of_type_JavaLangString);
          paramInt1 = i - DisplayUtil.dip2px(localContext, DisplayUtil.dip2px(localContext, parambazs.jdField_a_of_type_Bazu.jdField_b_of_type_Int) + 4);
          break;
        }
        a(parambbib.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, parambazs.jdField_a_of_type_Bazu.jdField_a_of_type_JavaLangString);
        paramInt1 = i - DisplayUtil.dip2px(localContext, 24.0F);
        break;
        label635:
        localObject1 = bbgk.a(parambbib.jdField_a_of_type_AndroidWidgetTextView, paramInt1, ((CharSequence)localObject1).toString());
        break label297;
        if (parambbib.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          parambbib.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
      label677:
      parambbib.c.removeAllViews();
      bazv localbazv;
      TextView localTextView;
      if ((parambazs.jdField_a_of_type_JavaUtilArrayList != null) && (parambazs.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        while (paramInt1 < parambazs.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localbazv = (bazv)parambazs.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
          localTextView = new TextView(localContext);
          a(localTextView, localbazv.jdField_a_of_type_JavaLangString, localbazv.jdField_a_of_type_Int);
          localObject1 = localbazv.jdField_a_of_type_JavaLangCharSequence;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramInt1 += 1;
          }
          else
          {
            if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
              break label1004;
            }
            localObject1 = ((CharSequence)localObject1).toString();
          }
        }
      }
      label952:
      label1004:
      for (;;)
      {
        paramInt2 = localbazv.jdField_a_of_type_Int;
        if ((localContext instanceof PublicAcntSearchActivity)) {
          paramInt2 = 1;
        }
        Object localObject2 = localObject1;
        if (localbazv.jdField_a_of_type_Boolean) {
          if ((!localbazv.jdField_a_of_type_JavaLangString.equals("A")) && (!localbazv.jdField_a_of_type_JavaLangString.equals("B"))) {
            break label952;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          localObject2 = bbgk.a(localTextView, i, paramInt2, ((CharSequence)localObject1).toString(), parambazs.jdField_a_of_type_Bbfz.jdField_a_of_type_JavaUtilList, false, bool, true);
          if (paramInt1 != 0) {
            localTextView.setPadding(0, DisplayUtil.dip2px(localContext, 7.0F - a(((bazv)parambazs.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1)).jdField_a_of_type_JavaLangString, localbazv.jdField_a_of_type_JavaLangString)), 0, 0);
          }
          localTextView.setText((CharSequence)localObject2);
          parambbib.c.addView(localTextView);
          break;
        }
        parambbib.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        b(parambazs, parambbib);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        parambbib.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
        return parambbib.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
      }
      label1007:
      paramInt1 = i;
    }
  }
  
  private StateListDrawable a(String paramString)
  {
    Object localObject;
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      localObject = "#040E1C";
    }
    for (paramString = "#194A90";; paramString = "#E5E6E7")
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      paramString = new ColorDrawable(Color.parseColor(paramString));
      localObject = new ColorDrawable(Color.parseColor((String)localObject));
      localStateListDrawable.addState(new int[] { 16842919, 16842910 }, paramString);
      localStateListDrawable.addState(new int[0], (Drawable)localObject);
      return localStateListDrawable;
      localObject = paramString;
      if (!bbgk.e(paramString)) {
        localObject = "#F1F1F1";
      }
    }
  }
  
  public static Pair<Integer, Integer> a(bazc parambazc, bbhi parambbhi, boolean paramBoolean, int paramInt)
  {
    if ((parambbhi == null) || (parambbhi.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (parambbhi.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (parambazc == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "bindUniversalTemplateLeftImageview or item is null");
      }
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    SquareImageView localSquareImageView = parambbhi.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
    bazd localbazd = parambazc.jdField_a_of_type_Bazd;
    if ((localbazd == null) || (TextUtils.isEmpty(localbazd.jdField_a_of_type_JavaLangString)))
    {
      parambbhi.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    parambbhi.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    Object localObject = localSquareImageView.getContext();
    parambazc = a(localSquareImageView, localbazd.jdField_a_of_type_Int, localbazd.jdField_a_of_type_JavaLangString, localbazd.jdField_b_of_type_Int, paramBoolean, paramInt, parambazc);
    paramInt = ((Integer)parambazc.first).intValue();
    int i = ((Integer)parambazc.second).intValue();
    parambazc = localSquareImageView.getLayoutParams();
    parambazc.width = paramInt;
    parambazc.height = i;
    localSquareImageView.setLayoutParams(parambazc);
    parambazc = (RelativeLayout.LayoutParams)parambbhi.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    parambazc.width = paramInt;
    parambazc.height = i;
    parambbhi.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(parambazc);
    int j = DisplayUtil.dip2px((Context)localObject, 10.0F);
    if ((!TextUtils.isEmpty(localbazd.jdField_a_of_type_JavaLangCharSequence)) && (parambbhi.e != null)) {
      if (bbgk.e(localbazd.jdField_b_of_type_JavaLangString))
      {
        parambazc = localbazd.jdField_b_of_type_JavaLangString;
        ((GradientDrawable)parambbhi.e.getBackground()).setColor(Color.parseColor(parambazc));
        parambbhi.e.setVisibility(0);
        parambbhi.e.setText(localbazd.jdField_a_of_type_JavaLangCharSequence);
        label303:
        if (parambbhi.jdField_c_of_type_AndroidWidgetImageView != null)
        {
          if (!localbazd.jdField_a_of_type_Boolean) {
            break label565;
          }
          parambbhi.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        label326:
        if (parambbhi.f != null)
        {
          if (TextUtils.isEmpty(localbazd.jdField_b_of_type_JavaLangCharSequence)) {
            break label577;
          }
          parambbhi.f.setVisibility(0);
          parambbhi.f.setText(localbazd.jdField_b_of_type_JavaLangCharSequence);
        }
        label364:
        if (parambbhi.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView != null)
        {
          if (TextUtils.isEmpty(localbazd.jdField_c_of_type_JavaLangString)) {
            break label589;
          }
          parambbhi.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          parambazc = URLDrawable.URLDrawableOptions.obtain();
          localObject = new ColorDrawable(-1);
          parambazc.mFailedDrawable = ((Drawable)localObject);
          parambazc.mLoadingDrawable = ((Drawable)localObject);
          parambazc.mRequestWidth = parambbhi.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width;
          parambazc.mRequestHeight = parambbhi.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height;
          parambazc = URLDrawable.getDrawable(localbazd.jdField_c_of_type_JavaLangString, parambazc);
          if ((parambazc.getStatus() != 1) && (parambazc.getStatus() != 0)) {
            parambazc.restartDownload();
          }
          parambbhi.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(parambazc);
        }
        label481:
        if (parambbhi.g != null)
        {
          if (TextUtils.isEmpty(localbazd.jdField_c_of_type_JavaLangCharSequence)) {
            break label601;
          }
          parambbhi.g.setVisibility(0);
          parambbhi.g.setText(localbazd.jdField_c_of_type_JavaLangCharSequence);
        }
      }
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt + j), Integer.valueOf(i));
      parambazc = "#fd7f32";
      break;
      if (parambbhi.e == null) {
        break label303;
      }
      parambbhi.e.setVisibility(8);
      break label303;
      label565:
      parambbhi.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label326;
      label577:
      parambbhi.f.setVisibility(8);
      break label364;
      label589:
      parambbhi.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
      break label481;
      label601:
      parambbhi.g.setVisibility(8);
    }
  }
  
  public static Pair<Integer, Integer> a(SquareImageView paramSquareImageView, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, int paramInt3, bazc parambazc)
  {
    int j = 0;
    int i = 0;
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    Object localObject = paramSquareImageView.getContext();
    ColorDrawable localColorDrawable;
    switch (paramInt1)
    {
    default: 
      paramInt1 = DisplayUtil.dip2px((Context)localObject, 60.0F);
      i = DisplayUtil.dip2px((Context)localObject, 60.0F);
      j = 0;
      localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      if (paramBoolean)
      {
        paramInt1 = (int)(i * 1.0F / paramInt1 * paramInt3);
        if (j != 0)
        {
          i = (int)(paramInt3 * 0.2D / 2.0D);
          paramSquareImageView.setPadding(DisplayUtil.dip2px((Context)localObject, 3.0F), DisplayUtil.dip2px((Context)localObject, 3.0F), DisplayUtil.dip2px((Context)localObject, 3.0F), DisplayUtil.dip2px((Context)localObject, 3.0F));
          parambazc = (RelativeLayout.LayoutParams)paramSquareImageView.getLayoutParams();
          i -= DisplayUtil.dip2px((Context)localObject, 3.0F);
          parambazc.rightMargin = i;
          parambazc.leftMargin = i;
          parambazc.topMargin = i;
          paramSquareImageView.setLayoutParams(parambazc);
        }
      }
      break;
    }
    for (;;)
    {
      paramSquareImageView.setImageScale(paramInt3 * 1.0F / paramInt1, 0.0F);
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty(paramString)) {
            continue;
          }
          parambazc = URLDrawable.URLDrawableOptions.obtain();
          parambazc.mRequestWidth = paramInt3;
          parambazc.mRequestHeight = paramInt1;
          if (j == 0) {
            continue;
          }
          localObject = new GradientDrawable();
          ((GradientDrawable)localObject).setShape(0);
          ((GradientDrawable)localObject).setCornerRadius(paramInt3 / 2.0F);
          ((GradientDrawable)localObject).setColor(-1579033);
          parambazc.mLoadingDrawable = ((Drawable)localObject);
          parambazc.mFailedDrawable = ((Drawable)localObject);
          parambazc.mPlayGifImage = true;
          if (j == 0) {
            continue;
          }
          parambazc.mMemoryCacheKeySuffix = ("isAvatar" + paramInt3 + paramInt1);
          parambazc = URLDrawable.getDrawable(paramString, parambazc);
          parambazc.setDecodeHandler(bfol.a);
        }
        catch (Exception parambazc)
        {
          QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + paramString, parambazc);
          localObject = localColorDrawable;
          continue;
          parambazc.mMemoryCacheKeySuffix = ("isNotAvatar" + paramInt3 + paramInt1 + paramInt2);
          parambazc = URLDrawable.getDrawable(paramString, parambazc);
          parambazc.setTag(bfol.b(paramInt3, paramInt1, paramInt2));
          parambazc.setDecodeHandler(bfol.j);
          continue;
        }
        localObject = parambazc;
        if (parambazc.getStatus() != 1)
        {
          localObject = parambazc;
          if (parambazc.getStatus() != 0)
          {
            parambazc.restartDownload();
            localObject = parambazc;
          }
        }
        paramSquareImageView.setImageDrawable((Drawable)localObject);
        return new Pair(Integer.valueOf(paramInt3), Integer.valueOf(paramInt1));
        paramInt1 = DisplayUtil.dip2px((Context)localObject, 60.0F);
        i = DisplayUtil.dip2px((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = DisplayUtil.dip2px((Context)localObject, 50.0F);
        i = DisplayUtil.dip2px((Context)localObject, 50.0F);
        j = 0;
        break;
        if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
        {
          paramInt1 = DisplayUtil.dip2px(paramSquareImageView.getContext(), 50.0F);
          i = DisplayUtil.dip2px(paramSquareImageView.getContext(), 50.0F);
          j = 1;
          break;
        }
        paramInt1 = DisplayUtil.dip2px((Context)localObject, 60.0F);
        i = DisplayUtil.dip2px((Context)localObject, 60.0F);
        continue;
        paramInt1 = DisplayUtil.dip2px((Context)localObject, 50.0F);
        i = DisplayUtil.dip2px((Context)localObject, 50.0F);
        j = 1;
        break;
        paramInt1 = DisplayUtil.dip2px((Context)localObject, 60.0F);
        i = DisplayUtil.dip2px((Context)localObject, 85.0F);
        j = 0;
        break;
        paramInt1 = DisplayUtil.dip2px((Context)localObject, 113.0F);
        i = DisplayUtil.dip2px((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = DisplayUtil.dip2px((Context)localObject, 100.0F);
        i = DisplayUtil.dip2px((Context)localObject, 141.0F);
        j = 0;
        break;
        paramInt1 = j;
        if ((parambazc instanceof bazs))
        {
          paramInt1 = DisplayUtil.dip2px((Context)localObject, parambazc.jdField_a_of_type_Bazd.jdField_c_of_type_Int / 2);
          i = DisplayUtil.dip2px((Context)localObject, parambazc.jdField_a_of_type_Bazd.d / 2);
        }
        if ((paramInt2 == parambazc.jdField_a_of_type_Bazd.jdField_c_of_type_Int / 2) && (paramInt2 == parambazc.jdField_a_of_type_Bazd.d / 2))
        {
          j = 1;
          break;
        }
        j = 0;
        break;
        paramInt1 = DisplayUtil.dip2px((Context)localObject, 220.0F);
        i = DisplayUtil.dip2px((Context)localObject, 136.0F);
        j = 0;
        break;
        paramInt1 = DisplayUtil.dip2px((Context)localObject, 162.0F);
        i = DisplayUtil.dip2px((Context)localObject, 162.0F);
        j = 0;
        break;
        paramInt1 = DisplayUtil.dip2px((Context)localObject, 162.0F);
        i = DisplayUtil.dip2px((Context)localObject, 228.0F);
        j = 0;
        break;
        paramInt1 = DisplayUtil.dip2px((Context)localObject, 162.0F);
        i = DisplayUtil.dip2px((Context)localObject, 162.0F);
        j = 1;
        break;
        parambazc.mFailedDrawable = localColorDrawable;
        parambazc.mLoadingDrawable = localColorDrawable;
        paramSquareImageView.setBackgroundColor(0);
      }
      paramInt3 = paramInt1;
      paramInt1 = i;
    }
  }
  
  private void a(TextView paramTextView, String paramString, int paramInt)
  {
    if ((paramTextView == null) || (TextUtils.isEmpty(paramString)) || (paramInt <= 0)) {
      return;
    }
    Context localContext = paramTextView.getContext();
    paramTextView.setMaxLines(paramInt);
    paramTextView.setEllipsize(TextUtils.TruncateAt.END);
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (paramString.equals("A"))
    {
      paramTextView.setTextSize(1, 17.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#737373"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131167013));
      }
    }
    if (paramString.equals("B"))
    {
      paramTextView.setTextSize(1, 15.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#737373"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131167013));
      }
    }
    if (paramString.equals("C"))
    {
      paramTextView.setTextSize(1, 14.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131167014));
      }
    }
    if (paramString.equals("D"))
    {
      paramTextView.setTextSize(1, 13.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131167014));
      }
    }
    if (paramString.equals("E"))
    {
      paramTextView.setTextSize(1, 12.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131167014));
      }
    }
    if (paramString.equals("F"))
    {
      paramTextView.setTextSize(1, 12.0F);
      paramTextView.setIncludeFontPadding(false);
      if (bool)
      {
        paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
        return;
      }
      paramTextView.setTextColor(localContext.getResources().getColor(2131167160));
      return;
    }
    paramTextView.setTextSize(1, 17.0F);
    paramTextView.setTextColor(localContext.getResources().getColor(2131167019));
    paramTextView.setIncludeFontPadding(false);
  }
  
  private void a(baza parambaza, bbhg parambbhg)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3 = parambbhg.a().getContext();
    label59:
    int i;
    Object localObject2;
    int m;
    int n;
    label322:
    Object localObject4;
    int k;
    int j;
    if (ThemeUtil.isNowThemeIsNight((AppRuntime)localObject1, false, null))
    {
      parambbhg.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      if (!TextUtils.isEmpty(parambaza.jdField_a_of_type_JavaLangCharSequence)) {
        break label593;
      }
      parambbhg.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (parambaza.jdField_a_of_type_Bayv == null) {
        break label775;
      }
      parambbhg.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      parambbhg.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      i = (int)(DeviceInfoUtil.getWidth() - UIUtils.dip2px((Context)localObject3, 30.0F)) / 2 - UIUtils.dip2px((Context)localObject3, 3.0F);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
      localObject2 = URLDrawable.getDrawable(parambaza.jdField_a_of_type_Bayv.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
      parambbhg.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      localObject2 = (LinearLayout.LayoutParams)parambbhg.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = i;
      ((LinearLayout.LayoutParams)localObject2).width = i;
      parambbhg.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      parambbhg.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (parambaza.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      m = Math.min(parambaza.jdField_a_of_type_JavaUtilList.size(), 4);
      n = (i - UIUtils.dip2px((Context)localObject3, 3.0F)) / 2;
      localObject2 = new int[4];
      Object tmp295_293 = localObject2;
      tmp295_293[0] = 2131368378;
      Object tmp301_295 = tmp295_293;
      tmp301_295[1] = 2131368379;
      Object tmp307_301 = tmp301_295;
      tmp307_301[2] = 2131368380;
      Object tmp313_307 = tmp307_301;
      tmp313_307[3] = 2131368381;
      tmp313_307;
      i = 0;
      if (i >= m) {
        break label748;
      }
      localObject3 = (SquareImageView)parambbhg.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]);
      localObject4 = ((bayv)parambaza.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = n;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = n;
      localObject4 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject1);
      ((SquareImageView)localObject3).setImageDrawable((Drawable)localObject4);
      if ((((URLDrawable)localObject4).getStatus() != 1) && (((URLDrawable)localObject4).getStatus() != 0)) {
        ((URLDrawable)localObject4).restartDownload();
      }
      localObject4 = (LinearLayout.LayoutParams)((SquareImageView)localObject3).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject4).height = n;
      ((LinearLayout.LayoutParams)localObject4).width = n;
      ((SquareImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      ((SquareImageView)localObject3).setVisibility(0);
      if ((i != 3) || (parambaza.jdField_a_of_type_Int <= 4)) {
        break label731;
      }
      ((SquareImageView)localObject3).setFilterColor(Color.parseColor("#66000000"));
      k = parambaza.jdField_a_of_type_Int - 4;
      localObject4 = new StringBuilder().append("+");
      j = k;
      if (k > 99) {
        j = 99;
      }
      ((SquareImageView)localObject3).setFilterText(j);
      ((SquareImageView)localObject3).setFilterTextSize(DisplayUtil.dip2px(parambbhg.a().getContext(), 20.0F));
    }
    for (;;)
    {
      i += 1;
      break label322;
      parambbhg.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      break;
      label593:
      i = (int)(parambbhg.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px(parambbhg.jdField_a_of_type_AndroidWidgetTextView.getContext(), 30.0F) - bbgk.a(parambbhg.jdField_a_of_type_AndroidWidgetTextView, parambaza.jdField_a_of_type_JavaLangString));
      localObject2 = bbgk.a(parambbhg.jdField_a_of_type_AndroidWidgetTextView, i, 1, parambaza.jdField_a_of_type_JavaLangCharSequence.toString(), parambaza.jdField_a_of_type_Bbfz.jdField_a_of_type_JavaUtilList, false, false, true);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (parambaza.jdField_a_of_type_JavaLangString == null) {
        parambaza.jdField_a_of_type_JavaLangString = "";
      }
      parambbhg.jdField_a_of_type_AndroidWidgetTextView.setText(new SpannableStringBuilder((CharSequence)localObject1).append(parambaza.jdField_a_of_type_JavaLangString));
      parambbhg.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break label59;
      label731:
      ((SquareImageView)localObject3).setFilterColor(-1);
      ((SquareImageView)localObject3).setFilterText("");
    }
    label748:
    while (i < 4)
    {
      parambbhg.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]).setVisibility(4);
      i += 1;
    }
    label775:
    parambbhg.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    parambbhg.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (parambaza.jdField_a_of_type_JavaUtilList != null)
    {
      m = Math.min(parambaza.jdField_a_of_type_JavaUtilList.size(), parambbhg.jdField_a_of_type_Int);
      n = (int)(DeviceInfoUtil.getWidth() - UIUtils.dip2px(parambbhg.a().getContext(), (m - 1) * 2 + 27));
      i = 0;
      if (i < m)
      {
        localObject1 = (SquareImageView)parambbhg.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        localObject2 = ((bayv)parambaza.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = n;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = n;
        ((URLDrawable.URLDrawableOptions)localObject4).mMemoryCacheKeySuffix = "fourPic";
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
        ((SquareImageView)localObject1).setImageDrawable((Drawable)localObject2);
        if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
          ((URLDrawable)localObject2).restartDownload();
        }
        if (parambaza.jdField_b_of_type_Int != 0)
        {
          ((SquareImageView)localObject1).setImageScale(n / 4 * 1.0F / DisplayUtil.dip2px((Context)localObject3, parambaza.jdField_b_of_type_Int / 2), 0.0F);
          label1007:
          ((SquareImageView)localObject1).setVisibility(0);
          if ((i != parambbhg.jdField_a_of_type_Int - 1) || (parambaza.jdField_a_of_type_Int <= parambbhg.jdField_a_of_type_Int)) {
            break label1136;
          }
          ((SquareImageView)localObject1).setFilterColor(Color.parseColor("#66000000"));
          k = parambaza.jdField_a_of_type_Int - parambbhg.jdField_a_of_type_Int;
          localObject2 = new StringBuilder().append("+");
          j = k;
          if (k > 99) {
            j = 99;
          }
          ((SquareImageView)localObject1).setFilterText(j);
          ((SquareImageView)localObject1).setFilterTextSize(DisplayUtil.dip2px(parambbhg.a().getContext(), 20.0F));
        }
        for (;;)
        {
          i += 1;
          break;
          ((SquareImageView)localObject1).setImageScale(1.0F, 0.0F);
          break label1007;
          label1136:
          ((SquareImageView)localObject1).setFilterColor(-1);
          ((SquareImageView)localObject1).setFilterText("");
        }
      }
      while (i < parambbhg.jdField_a_of_type_Int)
      {
        parambbhg.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(4);
        i += 1;
      }
    }
  }
  
  private void a(bazb parambazb, bbhh parambbhh)
  {
    Object localObject = parambbhh.a().getContext();
    int i;
    if (!TextUtils.isEmpty(parambazb.i))
    {
      parambbhh.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a((Context)localObject, (SquareImageView)parambbhh.jdField_a_of_type_AndroidWidgetImageView, parambbhh.jdField_b_of_type_AndroidWidgetImageView, parambbhh.jdField_b_of_type_AndroidWidgetTextView, parambazb.jdField_a_of_type_Int, parambazb.i, parambazb.jdField_b_of_type_JavaLangString, ((Context)localObject).getResources().getDimensionPixelSize(2131298389));
      i = ((Context)localObject).getResources().getDimensionPixelSize(2131298389);
      if ((parambazb.jdField_a_of_type_Int == 6) || (parambazb.jdField_a_of_type_Int == 8)) {
        i = DisplayUtil.dip2px((Context)localObject, 100.0F);
      }
      if (parambbhh.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        break label317;
      }
      i = 0;
      label127:
      float f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px((Context)localObject, 30.0F);
      CharSequence localCharSequence = bbgk.a(parambbhh.jdField_a_of_type_AndroidWidgetTextView, f, 2, parambazb.jdField_a_of_type_JavaLangCharSequence.toString(), parambazb.jdField_a_of_type_Bbfz.jdField_a_of_type_JavaUtilList, false, true);
      parambbhh.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
      f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px((Context)localObject, 30.0F) - i;
      localObject = bbgk.a(parambbhh.c, f, 2, parambazb.jdField_b_of_type_JavaLangCharSequence.toString(), parambazb.jdField_a_of_type_Bbfz.jdField_a_of_type_JavaUtilList, false, false);
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label333;
      }
      parambbhh.c.setTextColor(Color.parseColor("#4A4A4A"));
      parambbhh.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      a(parambbhh.c, (CharSequence)localObject, true);
      a(parambbhh.jdField_d_of_type_AndroidWidgetTextView, parambazb.jdField_c_of_type_JavaLangCharSequence);
      return;
      parambbhh.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break;
      label317:
      i += DisplayUtil.dip2px((Context)localObject, 10.0F);
      break label127;
      label333:
      parambbhh.c.setTextColor(Color.parseColor("#737373"));
      parambbhh.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(baze parambaze, bbhj parambbhj)
  {
    Context localContext = parambbhj.a().getContext();
    int j;
    int i;
    if (parambaze.jdField_a_of_type_Int == 1)
    {
      j = DisplayUtil.dip2px(localContext, 375.0F);
      i = DisplayUtil.dip2px(localContext, 150.0F);
    }
    for (;;)
    {
      int k;
      if ((j == 0) || (i == 0))
      {
        i = DisplayUtil.dip2px(localContext, 375.0F);
        j = DisplayUtil.dip2px(localContext, 150.0F);
        k = i;
        i = j;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(parambaze.jdField_b_of_type_JavaLangString))
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = k;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          localObject = URLDrawable.getDrawable(parambaze.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
          parambbhj.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
            ((URLDrawable)localObject).restartDownload();
          }
          label164:
          parambbhj.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)parambbhj.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).height = ((int)(i * UIUtils.getWindowScreenWidth(localContext) * 1.0F / k));
          parambbhj.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          parambbhj.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
          if (TextUtils.isEmpty(parambaze.jdField_a_of_type_JavaLangCharSequence)) {
            break label522;
          }
          parambbhj.jdField_b_of_type_AndroidWidgetTextView.setText(parambaze.jdField_a_of_type_JavaLangCharSequence);
          parambbhj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          label253:
          if (TextUtils.isEmpty(parambaze.jdField_b_of_type_JavaLangCharSequence)) {
            break label534;
          }
          parambbhj.c.setText(parambaze.jdField_b_of_type_JavaLangCharSequence);
          parambbhj.c.setVisibility(0);
          label282:
          if (TextUtils.isEmpty(parambaze.j)) {
            break label599;
          }
          parambbhj.jdField_d_of_type_AndroidWidgetTextView.setText(parambaze.j);
        }
        try
        {
          if (!parambaze.k.startsWith("#")) {
            parambaze.k = ("#" + parambaze.k);
          }
          parambbhj.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor(parambaze.k));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label365:
            parambbhj.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#FF00FF00"));
            if (QLog.isColorLevel()) {
              QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bigImageItem.topLeftTagColor = " + parambaze.k);
            }
          }
        }
        parambbhj.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        Object localObject = ((ViewGroup)parambbhj.a()).getChildAt(((ViewGroup)parambbhj.a()).getChildCount() - 1);
        if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof LinearLayout.LayoutParams)))
        {
          if (parambaze.b() != 0) {
            break label611;
          }
          ((LinearLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = 0;
          parambbhj.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, DisplayUtil.dip2px(localContext, 6.0F));
        }
        label522:
        label534:
        label599:
        label611:
        while (parambaze.b() != 2)
        {
          return;
          if (parambaze.jdField_a_of_type_Int == 2)
          {
            j = DisplayUtil.dip2px(localContext, 375.0F);
            i = DisplayUtil.dip2px(localContext, 180.0F);
            break;
          }
          if (parambaze.jdField_a_of_type_Int != 0) {
            break label639;
          }
          j = DisplayUtil.dip2px(localContext, parambaze.jdField_a_of_type_Float / 2.0F);
          i = DisplayUtil.dip2px(localContext, parambaze.jdField_b_of_type_Float / 2.0F);
          break;
          parambbhj.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label164;
          parambbhj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label253;
          parambbhj.c.setVisibility(8);
          break label282;
          parambbhj.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          break label365;
        }
        ((LinearLayout.LayoutParams)localException.getLayoutParams()).bottomMargin = 0;
        return;
        k = j;
      }
      label639:
      i = 0;
      j = 0;
    }
  }
  
  private void a(bazg parambazg, bbhl parambbhl)
  {
    Object localObject1 = parambbhl.a().getContext();
    Object localObject2 = parambbhl.a();
    if (parambazg.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.dip2px(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), UIUtils.dip2px(((View)localObject2).getContext(), 6.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131372634);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368440);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.dip2px(((View)localObject2).getContext(), 3.0F), ((View)localObject2).getPaddingRight(), UIUtils.dip2px(((View)localObject2).getContext(), 3.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (parambazg.jdField_c_of_type_Boolean)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(UIUtils.dip2px((Context)localObject1, 4.0F));
          i += 1;
        }
      }
      i = 0;
      while (i < ((List)localObject3).size())
      {
        ((SquareImageView)((List)localObject3).get(i)).setRoundRect(0);
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(parambazg.i)) {
      a((Context)localObject1, (SquareImageView)parambbhl.b(), parambbhl.jdField_b_of_type_AndroidWidgetImageView, parambbhl.jdField_a_of_type_AndroidWidgetTextView, parambazg.jdField_a_of_type_Int, parambazg.i, null, DisplayUtil.dip2px((Context)localObject1, 32.0F));
    }
    label687:
    Object localObject5;
    if (!TextUtils.isEmpty(parambazg.jdField_a_of_type_JavaLangString))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = parambbhl.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = parambbhl.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(parambazg.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      parambbhl.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      parambbhl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298389);
      if ((parambazg.jdField_a_of_type_Int == 6) || (parambazg.jdField_a_of_type_Int == 8)) {
        i = DisplayUtil.dip2px((Context)localObject1, 100.0F);
      }
      localObject2 = bbgk.a(parambbhl.a(), 10.0F * bbgk.a(parambbhl.a(), amtj.a(2131712776)), 1, parambazg.jdField_a_of_type_JavaLangCharSequence.toString(), parambazg.jdField_a_of_type_Bbfz.jdField_a_of_type_JavaUtilList, false, false, true);
      parambbhl.a().setText((CharSequence)localObject2);
      parambbhl.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px((Context)localObject1, 40.0F) - i;
      localObject2 = bbgk.a(parambbhl.b(), f1, 2, parambazg.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(parambbhl.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(parambazg.jdField_c_of_type_JavaLangCharSequence)) {
        break label1047;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px((Context)localObject1, 30.0F);
      localObject2 = bbgk.a(parambbhl.c(), f1, 2, parambazg.jdField_c_of_type_JavaLangCharSequence.toString(), parambazg.jdField_a_of_type_Bbfz.jdField_a_of_type_JavaUtilList, false, false);
      parambbhl.c().setText((CharSequence)localObject2);
      parambbhl.c().setVisibility(0);
      if (parambazg.jdField_a_of_type_JavaUtilList == null) {
        break label1479;
      }
      if (parambazg.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1071;
      }
      parambbhl.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      parambbhl.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject3 = parambbhl.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject3).getDisplayMetrics().widthPixels;
      }
      localObject2 = parambbhl.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject2).setImageScale((float)(1.0D / parambazg.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject3).getDimension(2131298382);
      float f2 = ((Resources)localObject3).getDimension(2131298382);
      i = DisplayUtil.dip2px(parambbhl.a().getContext(), 2.0F);
      j = parambbhl.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * parambazg.jdField_b_of_type_Double);
      j = (int)(j * parambazg.jdField_b_of_type_Double);
      ((SquareImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      localObject3 = (bayv)parambazg.jdField_a_of_type_JavaUtilList.get(0);
      localObject4 = ((bayv)localObject3).jdField_a_of_type_JavaLangString;
      localObject5 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight = j;
      ((URLDrawable.URLDrawableOptions)localObject5).mPlayGifImage = true;
      localObject4 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject5);
      ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject4);
      if ((((URLDrawable)localObject4).getStatus() != 1) && (((URLDrawable)localObject4).getStatus() != 0)) {
        ((URLDrawable)localObject4).restartDownload();
      }
      if (((bayv)localObject3).jdField_a_of_type_Int != 2) {
        break label1059;
      }
      parambbhl.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if ((parambazg.jdField_c_of_type_JavaUtilList != null) || (!TextUtils.equals(parambazg.k, "0")) || (!TextUtils.equals(parambazg.m, "0"))) {
        break label1500;
      }
      parambbhl.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
      parambbhl.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1047:
      parambbhl.c().setVisibility(8);
      break label687;
      label1059:
      parambbhl.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      label1071:
      parambbhl.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      parambbhl.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = parambbhl.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < parambazg.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = parambbhl.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368440);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131369609);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / parambazg.jdField_a_of_type_Double), 0.0F);
          localObject4 = (bayv)parambazg.jdField_a_of_type_JavaUtilList.get(i);
          localObject5 = ((bayv)localObject4).jdField_a_of_type_JavaLangString;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestHeight = 200;
          localURLDrawableOptions.mRequestWidth = 200;
          localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mPlayGifImage = true;
          localObject5 = URLDrawable.getDrawable((String)localObject5, localURLDrawableOptions);
          ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject5);
          if ((((URLDrawable)localObject5).getStatus() != 1) && (((URLDrawable)localObject5).getStatus() != 0)) {
            ((URLDrawable)localObject5).restartDownload();
          }
          ((SquareImageView)localObject2).setVisibility(0);
          if (((bayv)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1312:
            if ((i != m - 1) || (parambazg.jdField_b_of_type_Int <= m)) {
              break label1433;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            int k = parambazg.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(DisplayUtil.dip2px(((SquareImageView)localObject2).getContext(), 20.0F));
          }
          for (;;)
          {
            i += 1;
            break;
            ((ImageView)localObject3).setVisibility(8);
            break label1312;
            label1433:
            ((SquareImageView)localObject2).setFilterColor(-1);
            ((SquareImageView)localObject2).setFilterText("");
          }
        }
      }
      while (j < m)
      {
        parambbhl.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
      continue;
      label1479:
      parambbhl.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      parambbhl.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    label1500:
    if (parambazg.jdField_c_of_type_JavaUtilList != null)
    {
      parambbhl.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      i = parambazg.jdField_c_of_type_JavaUtilList.size() - 1;
      if (i < 0) {
        break label1758;
      }
      if (i <= 0) {
        break label2130;
      }
    }
    label1929:
    label2084:
    label2096:
    label2108:
    label2120:
    label2130:
    for (int j = DisplayUtil.dip2px((Context)localObject1, 11.0F) * i;; j = 0)
    {
      localObject2 = (SquareImageView)LayoutInflater.from((Context)localObject1).inflate(2131559822, null, false);
      localObject3 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px((Context)localObject1, 16.0F), DisplayUtil.dip2px((Context)localObject1, 16.0F));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = j;
      parambbhl.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, parambazg.jdField_c_of_type_JavaUtilList.size() - 1 - i, (ViewGroup.LayoutParams)localObject3);
      localObject3 = (String)parambazg.jdField_c_of_type_JavaUtilList.get(i);
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((SquareImageView)localObject2).getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = ((SquareImageView)localObject2).getLayoutParams().height;
      localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
      ((URLDrawable)localObject3).setDecodeHandler(bfol.a);
      ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject3);
      if ((((URLDrawable)localObject3).getStatus() != 1) && (((URLDrawable)localObject3).getStatus() != 0)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      ((SquareImageView)localObject2).setVisibility(0);
      i -= 1;
      break;
      parambbhl.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      label1758:
      if (!TextUtils.isEmpty(parambazg.jdField_b_of_type_JavaLangString))
      {
        parambbhl.jdField_b_of_type_AndroidWidgetTextView.setText(parambazg.jdField_b_of_type_JavaLangString);
        parambbhl.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (TextUtils.isEmpty(parambazg.j)) {
          break label2084;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = parambbhl.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = parambbhl.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(parambazg.j, (URLDrawable.URLDrawableOptions)localObject1);
        parambbhl.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        parambbhl.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        label1900:
        if (TextUtils.isEmpty(parambazg.k)) {
          break label2096;
        }
        parambbhl.c.setText(parambazg.k);
        parambbhl.c.setVisibility(0);
        if (TextUtils.isEmpty(parambazg.l)) {
          break label2108;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = parambbhl.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = parambbhl.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(parambazg.l, (URLDrawable.URLDrawableOptions)localObject1);
        parambbhl.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        parambbhl.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(parambazg.m)) {
          break label2120;
        }
        parambbhl.jdField_d_of_type_AndroidWidgetTextView.setText(parambazg.m);
        parambbhl.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        parambbhl.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        parambbhl.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        break label1900;
        parambbhl.c.setVisibility(8);
        break label1929;
        parambbhl.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      parambbhl.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void a(bazm parambazm, bbhr parambbhr)
  {
    Object localObject = parambbhr.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(parambazm.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.dip2px(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.dip2px(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(parambazm.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      parambbhr.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      parambbhr.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(parambazm.j)) {
        break label504;
      }
      parambbhr.jdField_a_of_type_AndroidWidgetTextView.setText(parambazm.j);
      parambbhr.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(parambazm.g)) {
        break label516;
      }
      parambbhr.jdField_b_of_type_AndroidWidgetTextView.setText(parambazm.g);
      parambbhr.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(parambazm.k)) {
        break label528;
      }
      parambbhr.c.setVisibility(0);
      parambbhr.c.setText(parambazm.k);
      label262:
      if (TextUtils.isEmpty(parambazm.l)) {
        break label540;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.dip2px(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.dip2px(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "rightIcon";
      localObject = URLDrawable.getDrawable(parambazm.l, (URLDrawable.URLDrawableOptions)localObject);
      parambbhr.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      parambbhr.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      label377:
      parambbhr.a(parambazm);
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label552;
      }
      parambbhr.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839429);
      parambbhr.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839429);
      parambbhr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      parambbhr.c.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      if (parambbhr.jdField_b_of_type_AndroidWidgetTextView != null) {
        parambbhr.jdField_b_of_type_AndroidWidgetTextView.setTextColor(bbgk.b());
      }
      parambbhr.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new bbcq(this, parambazm, localContext));
      parambbhr.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new bbcr(this, parambazm, localContext));
      return;
      parambbhr.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label504:
      parambbhr.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label516:
      parambbhr.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label233;
      label528:
      parambbhr.c.setVisibility(8);
      break label262;
      label540:
      parambbhr.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label377;
      label552:
      parambbhr.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839428);
      parambbhr.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839428);
      parambbhr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      parambbhr.c.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(bazn parambazn, bbht parambbht)
  {
    Object localObject = parambbht.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(parambazn.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.dip2px(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.dip2px(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(parambazn.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      parambbht.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      parambbht.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(parambazn.j)) {
        break label363;
      }
      parambbht.jdField_a_of_type_AndroidWidgetTextView.setText(parambazn.j);
      parambbht.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(parambazn.g)) {
        break label375;
      }
      parambbht.c.setText(parambazn.g);
      parambbht.c.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(parambazn.k)) {
        break label387;
      }
      parambbht.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      parambbht.jdField_d_of_type_AndroidWidgetTextView.setText(parambazn.k);
      label262:
      if (!parambazn.jdField_b_of_type_Boolean) {
        break label399;
      }
      parambbht.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      bbda.a(null, 0, parambazn.jdField_c_of_type_Int, "0X8009D5C", 0, 0, null, null);
      if ((parambazn.jdField_a_of_type_JavaUtilList != null) && (parambazn.jdField_a_of_type_JavaUtilList.size() > 0)) {
        bbda.a(null, 0, parambazn.jdField_c_of_type_Int, "0X8009D5E", 0, 0, null, null);
      }
      parambbht.a(parambazn);
      parambbht.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new bbcp(this, parambazn, localContext));
      return;
      parambbht.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label363:
      parambbht.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label375:
      parambbht.c.setVisibility(8);
      break label233;
      label387:
      parambbht.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label262;
      label399:
      parambbht.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void a(bazp parambazp, bbhz parambbhz)
  {
    if ((parambazp == null) || (parambbhz == null)) {
      return;
    }
    parambbhz.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(parambbhz.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), 0, parambbhz.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), 0);
    Object localObject = (RelativeLayout.LayoutParams)parambbhz.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (parambazp.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localObject = parambbhz.jdField_a_of_type_AndroidWidgetTextView.getContext();
      int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px((Context)localObject, 38.0F);
      if (TextUtils.isEmpty(parambazp.jdField_b_of_type_JavaLangCharSequence)) {
        break label310;
      }
      parambbhz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!bool) {
        break label296;
      }
      parambbhz.jdField_b_of_type_AndroidWidgetTextView.setText(parambazp.jdField_b_of_type_JavaLangCharSequence.toString());
      label148:
      float f1 = i;
      float f2 = bbgk.a(parambbhz.jdField_b_of_type_AndroidWidgetTextView, parambazp.jdField_b_of_type_JavaLangCharSequence);
      i = (int)(f1 - (DisplayUtil.dip2px((Context)localObject, 10.0F) + f2));
      label182:
      if (TextUtils.isEmpty(parambazp.jdField_a_of_type_JavaLangCharSequence)) {
        break label334;
      }
      parambbhz.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = parambazp.jdField_a_of_type_JavaLangCharSequence;
      if (parambazp.jdField_b_of_type_Boolean) {
        break label346;
      }
      localObject = bbgk.a(parambbhz.jdField_a_of_type_AndroidWidgetTextView, i, (CharSequence)localObject);
    }
    label296:
    label310:
    label334:
    label346:
    for (;;)
    {
      if (bool) {
        parambbhz.jdField_a_of_type_AndroidWidgetTextView.setText(((CharSequence)localObject).toString());
      }
      for (;;)
      {
        parambbhz.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(a(parambazp.jdField_a_of_type_JavaLangString));
        parambbhz.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bbcs(this, parambazp, parambbhz));
        return;
        ((RelativeLayout.LayoutParams)localObject).addRule(14, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(5);
        break;
        parambbhz.jdField_b_of_type_AndroidWidgetTextView.setText(parambazp.jdField_b_of_type_JavaLangCharSequence);
        break label148;
        parambbhz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label182;
        parambbhz.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        continue;
        parambbhz.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void a(bazq parambazq, bbhy parambbhy)
  {
    if ((parambazq == null) || (parambbhy == null)) {}
    while ((TextUtils.isEmpty(parambazq.jdField_a_of_type_JavaLangString)) || (parambbhy.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    Context localContext = parambbhy.jdField_a_of_type_AndroidWidgetTextView.getContext();
    int j = localContext.getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px(localContext, 40.0F);
    int i;
    if ((!TextUtils.isEmpty(parambazq.e)) && (parambbhy.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      parambbhy.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      i = j - DisplayUtil.dip2px(localContext, 26.0F);
    }
    for (;;)
    {
      parambazq = bbgk.a(parambbhy.jdField_a_of_type_AndroidWidgetTextView, i, parambazq.jdField_a_of_type_JavaLangString);
      parambbhy.jdField_a_of_type_AndroidWidgetTextView.setText(parambazq);
      return;
      i = j;
      if (parambbhy.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        parambbhy.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        i = j;
      }
    }
  }
  
  private void a(bazs parambazs, bbib parambbib)
  {
    Context localContext = parambbib.jdField_b_of_type_AndroidWidgetRelativeLayout.getContext();
    Object localObject = (RelativeLayout.LayoutParams)parambbib.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)parambbib.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (parambazs.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(10, 0);
    }
    for (;;)
    {
      localObject = a(parambazs, parambbib, false, 0);
      if (((Integer)((Pair)localObject).first).intValue() != 0) {
        ((RelativeLayout.LayoutParams)parambbib.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).rightMargin = DisplayUtil.dip2px(localContext, 10.0F);
      }
      int i = a(parambazs, parambbib);
      int j = a(parambazs, parambbib, ((Integer)((Pair)localObject).first).intValue(), i);
      i = j;
      if (((Integer)((Pair)localObject).second).intValue() > j) {
        i = ((Integer)((Pair)localObject).second).intValue();
      }
      if (parambbib.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        ((RelativeLayout.LayoutParams)parambbib.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = i;
      }
      return;
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      localLayoutParams.addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
      localLayoutParams.addRule(15, 0);
    }
  }
  
  private void a(bazw parambazw, bbic parambbic)
  {
    Object localObject1 = parambbic.a().getContext();
    Object localObject2 = parambbic.a();
    if (parambazw.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.dip2px(((View)localObject2).getContext(), 9.0F), ((View)localObject2).getPaddingRight(), UIUtils.dip2px(((View)localObject2).getContext(), 9.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131372634);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368440);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.dip2px(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), UIUtils.dip2px(((View)localObject2).getContext(), 6.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (parambazw.jdField_c_of_type_Boolean)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(UIUtils.dip2px((Context)localObject1, 4.0F));
          i += 1;
        }
      }
      i = 0;
      while (i < ((List)localObject3).size())
      {
        ((SquareImageView)((List)localObject3).get(i)).setRoundRect(0);
        i += 1;
      }
    }
    label496:
    int j;
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      parambbic.a().setTextColor(Color.parseColor("#6991B8"));
      parambbic.c().setTextColor(Color.parseColor("#44608A"));
      parambbic.b().setTextColor(Color.parseColor("#44608A"));
      if (!TextUtils.isEmpty(parambazw.i)) {
        a((Context)localObject1, (SquareImageView)parambbic.b(), parambbic.jdField_b_of_type_AndroidWidgetImageView, parambbic.jdField_a_of_type_AndroidWidgetTextView, parambazw.jdField_a_of_type_Int, parambazw.i, null, DisplayUtil.dip2px((Context)localObject1, 21.0F));
      }
      if (TextUtils.isEmpty(parambazw.jdField_a_of_type_JavaLangString)) {
        break label1085;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = parambbic.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = parambbic.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(parambazw.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      parambbic.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      parambbic.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298389);
      if ((parambazw.jdField_a_of_type_Int == 6) || (parambazw.jdField_a_of_type_Int == 8)) {
        i = DisplayUtil.dip2px((Context)localObject1, 100.0F);
      }
      localObject2 = bbgk.a(parambbic.a(), 10.0F * bbgk.a(parambbic.a(), amtj.a(2131712775)), 1, parambazw.jdField_a_of_type_JavaLangCharSequence.toString(), parambazw.jdField_a_of_type_Bbfz.jdField_a_of_type_JavaUtilList, false, false, true);
      parambbic.a().setText((CharSequence)localObject2);
      parambbic.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px((Context)localObject1, 40.0F) - i;
      localObject2 = bbgk.a(parambbic.b(), f1, 2, parambazw.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(parambbic.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(parambazw.jdField_c_of_type_JavaLangCharSequence)) {
        break label1097;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px((Context)localObject1, 30.0F);
      localObject2 = bbgk.a(parambbic.c(), f1, 2, parambazw.jdField_c_of_type_JavaLangCharSequence.toString(), parambazw.jdField_a_of_type_Bbfz.jdField_a_of_type_JavaUtilList, false, false);
      parambbic.c().setText((CharSequence)localObject2);
      parambbic.c().setVisibility(0);
      label740:
      if (parambazw.jdField_a_of_type_JavaUtilList == null) {
        break label1546;
      }
      if (parambazw.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1119;
      }
      parambbic.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      parambbic.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject2 = parambbic.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject2).getDisplayMetrics().widthPixels;
      }
      localObject1 = parambbic.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject1).setImageScale((float)(1.0D / parambazw.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject2).getDimension(2131298382);
      float f2 = ((Resources)localObject2).getDimension(2131298382);
      i = DisplayUtil.dip2px(parambbic.a().getContext(), 2.0F);
      j = parambbic.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * parambazw.jdField_b_of_type_Double);
      j = (int)(j * parambazw.jdField_b_of_type_Double);
      ((SquareImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      parambazw = (bayv)parambazw.jdField_a_of_type_JavaUtilList.get(0);
      localObject2 = parambazw.jdField_a_of_type_JavaLangString;
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = j;
      ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
      localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
      ((SquareImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      if (parambazw.jdField_a_of_type_Int != 2) {
        break label1109;
      }
      parambbic.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      return;
      parambbic.a().setTextColor(Color.parseColor("#262626"));
      parambbic.c().setTextColor(Color.parseColor("#737373"));
      parambbic.b().setTextColor(Color.parseColor("#737373"));
      break;
      label1085:
      parambbic.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label496;
      label1097:
      parambbic.c().setVisibility(8);
      break label740;
      label1109:
      parambbic.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      label1119:
      parambbic.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      parambbic.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = parambbic.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < parambazw.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = parambbic.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368440);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131369609);
          j = UIUtils.getWindowScreenWidth((Context)localObject1) / m;
          int k = (int)(j * parambazw.jdField_a_of_type_Double);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / parambazw.jdField_a_of_type_Double), 0.0F);
          localObject4 = (bayv)parambazw.jdField_a_of_type_JavaUtilList.get(i);
          Object localObject5 = ((bayv)localObject4).jdField_a_of_type_JavaLangString;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mRequestWidth = j;
          localURLDrawableOptions.mRequestHeight = k;
          localURLDrawableOptions.mPlayGifImage = true;
          localObject5 = URLDrawable.getDrawable((String)localObject5, localURLDrawableOptions);
          ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject5);
          if ((((URLDrawable)localObject5).getStatus() != 1) && (((URLDrawable)localObject5).getStatus() != 0)) {
            ((URLDrawable)localObject5).restartDownload();
          }
          ((SquareImageView)localObject2).setVisibility(0);
          if (((bayv)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1379:
            if ((i != m - 1) || (parambazw.jdField_b_of_type_Int <= m)) {
              break label1500;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            k = parambazw.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(DisplayUtil.dip2px(((SquareImageView)localObject2).getContext(), 20.0F));
          }
          for (;;)
          {
            i += 1;
            break;
            ((ImageView)localObject3).setVisibility(8);
            break label1379;
            label1500:
            ((SquareImageView)localObject2).setFilterColor(-1);
            ((SquareImageView)localObject2).setFilterText("");
          }
        }
      }
      while (j < m)
      {
        parambbic.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
    }
    label1546:
    parambbic.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    parambbic.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void a(SquareImageView paramSquareImageView, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    paramSquareImageView.getLayoutParams().width = DisplayUtil.dip2px(paramSquareImageView.getContext(), paramInt1);
    paramSquareImageView.getLayoutParams().height = DisplayUtil.dip2px(paramSquareImageView.getContext(), paramInt2);
    paramSquareImageView.setImageScale(paramInt1 / paramInt2, 0.0F);
    localURLDrawableOptions.mRequestWidth = paramSquareImageView.getLayoutParams().width;
    localURLDrawableOptions.mRequestHeight = paramSquareImageView.getLayoutParams().height;
    paramSquareImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  private void a(SquareImageView paramSquareImageView, String paramString)
  {
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mRequestWidth = paramSquareImageView.getLayoutParams().width;
    localURLDrawableOptions.mRequestHeight = paramSquareImageView.getLayoutParams().height;
    paramSquareImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  private void b(bazs parambazs, bbib parambbib)
  {
    if ((parambazs == null) || (parambazs.jdField_a_of_type_Bazt == null) || (parambbib == null)) {
      if ((parambbib != null) && (parambbib.jdField_b_of_type_AndroidWidgetButton != null)) {
        parambbib.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
    while (parambbib.jdField_b_of_type_AndroidWidgetButton == null) {
      return;
    }
    Context localContext = parambbib.jdField_b_of_type_AndroidWidgetButton.getContext();
    if ((parambazs.jdField_a_of_type_Bazt.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(parambazs.jdField_a_of_type_Bazt.jdField_a_of_type_JavaLangCharSequence)))
    {
      parambbib.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      parambbib.jdField_b_of_type_AndroidWidgetButton.setText(parambazs.jdField_a_of_type_Bazt.jdField_a_of_type_JavaLangCharSequence);
      parambbib.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new bbcv(this, localContext, parambazs));
      return;
    }
    parambbib.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  public void a(Context paramContext, SquareImageView paramSquareImageView, ImageView paramImageView, TextView paramTextView, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, false);
      return;
    case 2: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, (int)(paramInt2 * 1.4F), false, paramString1, null, 0, false);
      return;
    case 3: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130842339, false);
      return;
    case 4: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130842339, false);
      return;
    case 5: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, true);
      return;
    case 6: 
      paramInt1 = DisplayUtil.dip2px(paramContext, 62.0F);
      a(paramSquareImageView, paramImageView, paramTextView, DisplayUtil.dip2px(paramContext, 100.0F), paramInt1, false, paramString1, null, 2130842339, false);
      return;
    case 7: 
      a(paramSquareImageView, paramImageView, paramTextView, DisplayUtil.dip2px(paramContext, 100.0F), DisplayUtil.dip2px(paramContext, 62.0F), false, paramString1, paramString2, 0, false);
      return;
    }
    a(paramSquareImageView, paramImageView, paramTextView, DisplayUtil.dip2px(paramContext, 100.0F), DisplayUtil.dip2px(paramContext, 62.0F), false, paramString1, null, 0, false);
  }
  
  public void a(ImageView paramImageView)
  {
    if (paramImageView == null) {}
    Animation localAnimation;
    do
    {
      return;
      localAnimation = AnimationUtils.loadAnimation(paramImageView.getContext(), 2130772205);
    } while (localAnimation == null);
    localAnimation.setInterpolator(new LinearInterpolator());
    paramImageView.startAnimation(localAnimation);
  }
  
  public void a(TextView paramTextView, CharSequence paramCharSequence)
  {
    a(paramTextView, paramCharSequence, true);
  }
  
  public void a(TextView paramTextView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (!paramBoolean) {
      paramTextView.setEllipsize(null);
    }
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView.setText(paramCharSequence);
      if (paramTextView.getVisibility() != 0) {
        paramTextView.setVisibility(0);
      }
    }
    while (paramTextView.getVisibility() == 8) {
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  public void a(bazc parambazc, bbhi parambbhi)
  {
    bbgn.a(parambazc.a(), parambazc.b(), parambbhi.a(), parambazc.jdField_a_of_type_Boolean, parambazc.u, parambazc.g);
    switch (parambazc.d())
    {
    }
    for (;;)
    {
      b(parambazc, parambbhi);
      if (TextUtils.isEmpty(parambazc.i)) {
        c(parambazc, parambbhi);
      }
      return;
      a((baza)parambazc, (bbhg)parambbhi);
      continue;
      a((bazw)parambazc, (bbic)parambbhi);
      continue;
      a((bazb)parambazc, (bbhh)parambbhi);
      continue;
      a((bazj)parambazc, (bbho)parambbhi);
      continue;
      a((bazs)parambazc, (bbib)parambbhi);
      continue;
      a((bazp)parambazc, (bbhz)parambbhi);
      continue;
      a((bazq)parambazc, (bbhy)parambbhi);
      continue;
      a((bazg)parambazc, (bbhl)parambbhi);
      continue;
      a((baze)parambazc, (bbhj)parambbhi);
      continue;
      a((bazh)parambazc, (bbhm)parambbhi);
      continue;
      a((bazr)parambazc, (bbia)parambbhi);
      continue;
      a((bazo)parambazc, (bbhw)parambbhi);
      continue;
      a((bazm)parambazc, (bbhr)parambbhi);
      continue;
      a((bazn)parambazc, (bbht)parambbhi);
      continue;
      a((bazl)parambazc, (bbhq)parambbhi);
    }
  }
  
  public void a(bazc parambazc, bbhi parambbhi, Bitmap paramBitmap)
  {
    if (parambbhi.b() != null) {
      parambbhi.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(bazh parambazh, bbhm parambbhm)
  {
    if ((parambazh.jdField_a_of_type_JavaUtilArrayList == null) || (parambazh.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorSlidingContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
      return;
    }
    bauq localbauq2 = (bauq)parambbhm.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter();
    bauq localbauq1;
    if (localbauq2 != null)
    {
      localbauq1 = localbauq2;
      if (localbauq2.a() == parambazh.jdField_a_of_type_JavaUtilArrayList) {}
    }
    else
    {
      localbauq1 = new bauq(parambazh, this.jdField_a_of_type_Baup.jdField_b_of_type_Int, parambbhm.jdField_a_of_type_ComTencentWidgetHorizontalListView);
      parambbhm.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(localbauq1);
    }
    if (localbauq1.a() != parambazh.jdField_a_of_type_JavaUtilArrayList)
    {
      parambbhm.jdField_a_of_type_Bazh = parambazh;
      parambbhm.jdField_a_of_type_ComTencentWidgetHorizontalListView.resetCurrentX(parambazh.jdField_b_of_type_Int);
    }
    localbauq1.a(parambazh.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(bazj parambazj, bbho parambbho)
  {
    parambbho.a().getContext();
    parambbho.a();
    if ((parambazj.jdField_a_of_type_JavaUtilArrayList == null) || (parambazj.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
    }
    for (;;)
    {
      return;
      parambbho.a(parambazj);
      if (parambazj.jdField_a_of_type_JavaUtilArrayList.size() != parambbho.jdField_a_of_type_JavaUtilArrayList.size()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, view.size != model.size");
      }
      int j = parambazj.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((bazi)parambazj.jdField_a_of_type_JavaUtilArrayList.get(i)).a((bbhn)parambbho.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
    }
  }
  
  protected void a(bazl parambazl, bbhq parambbhq)
  {
    Object localObject1 = (LinearLayout)parambbhq.b();
    bayy localbayy;
    Object localObject2;
    bbhe localbbhe;
    if ((localObject1 != null) && (parambazl.a != null))
    {
      ((LinearLayout)localObject1).removeAllViews();
      if (((LinearLayout)localObject1).getParent() != null) {
        ((View)((LinearLayout)localObject1).getParent()).setPadding(0, 0, 0, 0);
      }
      localbayy = parambazl.a;
      parambazl = parambbhq.a().getContext();
      localObject2 = LayoutInflater.from(parambazl).inflate(2131562762, null);
      localbbhe = new bbhe((View)localObject2);
      Object localObject3 = ((View)localObject2).findViewById(2131368891);
      int i = ViewUtils.dip2px(6.0F);
      ((View)localObject3).setPadding(0, i, 0, i);
      ((LinearLayout)localObject1).addView((View)localObject2);
      if (localbayy.c() != null) {
        break label620;
      }
      if (localbbhe.c() != null) {
        localbbhe.c().setVisibility(8);
      }
      if (localbbhe.a() != null) {
        localbbhe.a().setVisibility(8);
      }
      localObject1 = localbbhe.a();
      if (localObject1 != null) {
        ((URLImageView)localObject1).setVisibility(8);
      }
      localObject1 = localbbhe.e();
      if (localObject1 != null)
      {
        ((TextView)localObject1).setVisibility(0);
        if (!TextUtils.isEmpty(localbayy.a())) {
          ((TextView)localObject1).setText(localbayy.a());
        }
      }
      if ((localbbhe.b() != null) && (!TextUtils.isEmpty(localbayy.g())))
      {
        localObject1 = localbayy.g();
        localObject2 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = DisplayUtil.dip2px(parambazl, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = DisplayUtil.dip2px(parambazl, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
        if (!bjnd.a((String)localObject1)) {
          break label745;
        }
        localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
        ((URLDrawable)localObject1).setTag(bfol.b(DisplayUtil.dip2px(parambazl, 50.0F), DisplayUtil.dip2px(parambbhq.a().getContext(), 50.0F), DisplayUtil.dip2px(parambazl, 3.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(bfol.j);
        localbbhe.b().setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
      }
      label397:
      localbbhe.a().setOnClickListener(new bbco(this, localbayy));
      if ((localbbhe.a() != null) && (localbayy.c()))
      {
        parambbhq = localbayy.h();
        localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = DisplayUtil.dip2px(parambazl, 40.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = DisplayUtil.dip2px(parambazl, 12.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        parambbhq = URLDrawable.getDrawable(parambbhq, (URLDrawable.URLDrawableOptions)localObject2);
        parambbhq.setTag(bfol.b(DisplayUtil.dip2px(parambazl, 38.0F), DisplayUtil.dip2px(parambazl, 12.0F), 0));
        parambbhq.setDecodeHandler(bfol.j);
        localbbhe.a().setImageDrawable(parambbhq);
        if ((parambbhq.getStatus() != 1) && (parambbhq.getStatus() != 0)) {
          parambbhq.restartDownload();
        }
      }
      parambazl = new MiniAppInfo();
      parambazl.appId = localbayy.a.appId;
      parambbhq = new MiniAppConfig(parambazl);
      if (localbayy.a.showMask != 1) {
        break label758;
      }
    }
    label620:
    label758:
    for (parambazl = "used";; parambazl = "unused")
    {
      MiniProgramLpReportDC04239.reportAsync(parambbhq, "search", "result_view", parambazl, localbayy.a());
      return;
      if ((localbbhe.c() != null) && (!TextUtils.isEmpty(localbayy.c())))
      {
        localbbhe.c().setVisibility(0);
        localbbhe.c().setText(localbayy.c());
      }
      for (;;)
      {
        if (localbbhe.a() != null) {
          localbbhe.a().setVisibility(0);
        }
        localObject1 = localbbhe.e();
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        if (TextUtils.isEmpty(localbayy.a())) {
          break;
        }
        localbbhe.a().setText(localbayy.a());
        break;
        if (localbbhe.c() != null) {
          localbbhe.c().setVisibility(8);
        }
      }
      localbbhe.b().setImageDrawable((Drawable)localObject2);
      break label397;
    }
  }
  
  protected void a(bazo parambazo, bbhw parambbhw)
  {
    Object localObject1 = parambbhw.a().getContext();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      parambbhw.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      parambbhw.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
      if (TextUtils.isEmpty(parambazo.jdField_b_of_type_JavaLangString)) {
        break label290;
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = DisplayUtil.dip2px((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = DisplayUtil.dip2px((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "askIcon";
      localObject2 = URLDrawable.getDrawable(parambazo.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      parambbhw.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      parambbhw.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    label290:
    for (;;)
    {
      label166:
      if (!TextUtils.isEmpty(parambazo.j))
      {
        int j = parambbhw.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
        int i = (int)bbgk.a(parambbhw.jdField_a_of_type_AndroidWidgetTextView, " ");
        int k = DisplayUtil.dip2px((Context)localObject1, 22.0F) / i;
        localObject1 = "";
        i = 0;
        for (;;)
        {
          if (i < k)
          {
            localObject1 = (String)localObject1 + " ";
            i += 1;
            continue;
            parambbhw.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
            parambbhw.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
            break;
            parambbhw.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            break label166;
          }
        }
        localObject1 = bbgk.a(parambbhw.jdField_a_of_type_AndroidWidgetTextView, j, 2, (String)localObject1 + parambazo.j, parambazo.jdField_a_of_type_Bbfz.jdField_a_of_type_JavaUtilList, false, false, true);
        parambbhw.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
    }
    parambbhw.a(parambazo);
    if ((!TextUtils.isEmpty(parambazo.k)) && (parambazo.jdField_a_of_type_JavaUtilList != null) && (parambazo.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      parambbhw.jdField_b_of_type_AndroidWidgetTextView.setText(parambazo.k);
      parambbhw.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    parambbhw.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void a(bazr parambazr, bbia parambbia)
  {
    if (!TextUtils.isEmpty(parambazr.jdField_b_of_type_JavaLangString))
    {
      parambbia.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = parambbia.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = parambbia.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
      localObject = URLDrawable.getDrawable(parambazr.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      parambbia.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      if (TextUtils.isEmpty(parambazr.j)) {
        break label345;
      }
      parambbia.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      int i = parambbia.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
      localObject = bbgk.a(parambbia.jdField_a_of_type_AndroidWidgetTextView, i, 1, parambazr.j, parambazr.jdField_a_of_type_Bbfz.jdField_a_of_type_JavaUtilList, false, false, true);
      parambbia.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label183:
      if (TextUtils.isEmpty(parambazr.l)) {
        break label357;
      }
      parambbia.jdField_b_of_type_AndroidWidgetTextView.setText(parambazr.l);
      parambbia.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      parambbia.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label220:
      if (TextUtils.isEmpty(parambazr.k)) {
        break label378;
      }
      parambbia.c.setText(parambazr.k);
      parambbia.c.setVisibility(0);
    }
    for (;;)
    {
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label390;
      }
      parambbia.jdField_a_of_type_AndroidWidgetTextView.setTextColor(parambbia.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166945));
      parambbia.c.setTextColor(parambbia.c.getContext().getResources().getColor(2131166944));
      parambbia.jdField_b_of_type_AndroidWidgetTextView.setTextColor(parambbia.jdField_b_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166944));
      return;
      parambbia.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label345:
      parambbia.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label183;
      label357:
      parambbia.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      parambbia.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label220;
      label378:
      parambbia.c.setVisibility(8);
    }
    label390:
    parambbia.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
    parambbia.c.setTextColor(Color.parseColor("#737373"));
    parambbia.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
  }
  
  public void a(SquareImageView paramSquareImageView, ImageView paramImageView, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, int paramInt3, boolean paramBoolean2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramSquareImageView.getLayoutParams();
    if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
    {
      localLayoutParams.width = DisplayUtil.dip2px(paramSquareImageView.getContext(), 50.0F);
      localLayoutParams.height = DisplayUtil.dip2px(paramSquareImageView.getContext(), 50.0F);
      paramSquareImageView.setLayoutParams(localLayoutParams);
      if (paramInt2 == 0) {
        break label273;
      }
      paramSquareImageView.setImageScale(paramInt1 * 1.0F / paramInt2, 0.0F);
      label71:
      if (!paramBoolean1) {
        break label282;
      }
      paramSquareImageView.setFilterColor(Color.parseColor("#66000000"));
      label86:
      if (paramInt3 == 0) {
        break label290;
      }
      paramImageView.setImageResource(paramInt3);
      paramImageView.setVisibility(0);
      label102:
      if ((paramString2 == null) || (TextUtils.isEmpty(paramString2))) {
        break label299;
      }
      paramTextView.setVisibility(0);
      paramTextView.setText(paramString2);
      label126:
      paramImageView = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable.setBounds(0, 0, paramInt1, paramInt2);
      paramString2 = paramImageView;
    }
    for (;;)
    {
      label273:
      label282:
      label290:
      label299:
      try
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          paramTextView = URLDrawable.URLDrawableOptions.obtain();
          paramTextView.mRequestWidth = paramInt1;
          paramTextView.mRequestHeight = paramInt2;
          paramTextView.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramTextView.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          if (!paramBoolean2) {
            continue;
          }
          paramTextView.mMemoryCacheKeySuffix = "isAvatar";
          paramTextView = URLDrawable.getDrawable(paramString1, paramTextView);
          paramTextView.setDecodeHandler(bfol.a);
          paramString2 = paramTextView;
          paramImageView = paramTextView;
          paramTextView = paramString2;
          paramString2 = paramTextView;
        }
      }
      catch (Exception paramTextView) {}
      try
      {
        if (paramTextView.getStatus() != 1)
        {
          paramString2 = paramTextView;
          if (paramTextView.getStatus() != 0)
          {
            paramTextView.restartDownload();
            paramString2 = paramTextView;
          }
        }
        paramSquareImageView.setImageDrawable(paramString2);
        return;
      }
      catch (Exception paramTextView)
      {
        break label326;
      }
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      break;
      paramSquareImageView.setImageScale(1.0F, 0.0F);
      break label71;
      paramSquareImageView.setFilterColor(-1);
      break label86;
      paramImageView.setVisibility(8);
      break label102;
      paramTextView.setVisibility(8);
      break label126;
      paramTextView.mMemoryCacheKeySuffix = "isNotAvatar";
      paramTextView = URLDrawable.getDrawable(paramString1, paramTextView);
      continue;
      label326:
      QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + paramString1, paramTextView);
      paramString2 = paramImageView;
    }
  }
  
  protected void b(bazc parambazc, bbhi parambbhi)
  {
    if (parambbhi.a() != null) {
      parambbhi.a().setOnClickListener(new bbcn(this, parambazc));
    }
  }
  
  public void c(bazc parambazc, bbhi parambbhi)
  {
    if ((parambbhi.b() != null) && ((parambazc instanceof bayq)) && (!TextUtils.isEmpty(parambazc.b()))) {
      parambbhi.b().setImageDrawable(bbgk.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, parambazc));
    }
  }
  
  public String getToken()
  {
    return QQPlayerService.a(7, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin());
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localImageView == null);
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    Resources localResources = localImageView.getContext().getResources();
    if (paramInt == 1)
    {
      localImageView.post(new SearchTemplatePresenter.10(this, bool, localImageView));
      return;
    }
    if (paramInt == 2)
    {
      localImageView.getContext();
      ((Integer)localImageView.getTag()).intValue();
      bbgk.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localImageView.post(new SearchTemplatePresenter.11(this, localImageView, bool));
      localImageView.setContentDescription(localResources.getString(2131690193));
      this.jdField_a_of_type_Baup.notifyDataSetChanged();
      return;
    }
    localImageView.post(new SearchTemplatePresenter.12(this, localImageView, bool));
    localImageView.setContentDescription(localResources.getString(2131690191));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcm
 * JD-Core Version:    0.7.0.1
 */