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

public class bcje
  implements axkk, bcie<bcfs, bcoa>
{
  public static int a;
  private long jdField_a_of_type_Long;
  public ColorDrawable a;
  public Drawable a;
  private bcbf jdField_a_of_type_Bcbf;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bcje(FaceDecoder paramFaceDecoder, bcbf parambcbf)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = URLDrawableHelper.TRANSPARENT;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    this.jdField_a_of_type_Bcbf = parambcbf;
  }
  
  private float a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 7.0F;
    }
    return 3.5F;
  }
  
  private int a(bcgi parambcgi, bcot parambcot)
  {
    if ((parambcgi == null) || (parambcgi.jdField_a_of_type_Bcgj == null) || (parambcot == null) || (parambcot.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      if ((parambcot != null) && (parambcot.jdField_a_of_type_AndroidWidgetButton != null)) {
        parambcot.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((parambcot != null) && (parambcot.jdField_a_of_type_AndroidWidgetImageView != null)) {
        parambcot.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    if (parambcgi.jdField_a_of_type_Bcgj.jdField_a_of_type_Int == 1)
    {
      if (parambcot.jdField_a_of_type_AndroidWidgetButton != null) {
        parambcot.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if (parambcot.jdField_a_of_type_AndroidWidgetImageView != null) {
        parambcot.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    Context localContext = parambcot.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext();
    int i;
    if (parambcgi.jdField_a_of_type_Bcgj.jdField_a_of_type_Int == 2)
    {
      if (parambcot.jdField_a_of_type_AndroidWidgetImageView != null) {
        parambcot.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (parambcot.jdField_a_of_type_AndroidWidgetButton == null) {
        return 0;
      }
      if (!TextUtils.isEmpty(parambcgi.jdField_a_of_type_Bcgj.jdField_a_of_type_JavaLangCharSequence))
      {
        parambcot.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        parambcot.jdField_a_of_type_AndroidWidgetButton.setText(parambcgi.jdField_a_of_type_Bcgj.jdField_a_of_type_JavaLangCharSequence);
        parambcot.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bcjl(this, localContext, parambcgi));
      }
      for (;;)
      {
        i = (int)(0 + (bcnc.a(parambcot.jdField_a_of_type_AndroidWidgetButton, parambcgi.jdField_a_of_type_Bcgj.jdField_a_of_type_JavaLangCharSequence) + DisplayUtil.dip2px(localContext, 32.0F) + DisplayUtil.dip2px(localContext, 15.0F)));
        if (!bool) {
          break;
        }
        parambcot.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843358);
        parambcot.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#6991B8"));
        return i;
        parambcot.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      parambcot.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843357);
      parambcot.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#000000"));
      return i;
    }
    int j;
    if (parambcgi.jdField_a_of_type_Bcgj.jdField_a_of_type_Int == 3)
    {
      if (parambcot.jdField_a_of_type_AndroidWidgetButton != null) {
        parambcot.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((parambcot.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (parambcot.jdField_a_of_type_AndroidWidgetImageView == null)) {
        return 0;
      }
      int k = ((Integer)parambcot.a().getTag(2131381184)).intValue();
      SongInfo localSongInfo1 = new SongInfo();
      i = 0;
      j = i;
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(parambcgi.h);
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
          bcnc.jdField_a_of_type_Long = localSongInfo2.jdField_a_of_type_Long;
          continue;
          parambcot.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849641);
          continue;
          if (this.jdField_a_of_type_Long != bcnc.jdField_a_of_type_Long) {
            continue;
          }
          parambcot.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849642);
          continue;
          parambcot.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849640);
          continue;
          parambcot.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
        }
        this.jdField_a_of_type_Long = localSongInfo1.jdField_a_of_type_Long;
        QQPlayerService.a(this);
        if (QQPlayerService.a() == 2) {
          continue;
        }
        bcnc.jdField_a_of_type_Long = -1L;
        if (!bool) {
          continue;
        }
        if (this.jdField_a_of_type_Long != bcnc.jdField_a_of_type_Long) {
          continue;
        }
        parambcot.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849643);
        if ((j == 0) || (i == 0) || (TextUtils.isEmpty(localSongInfo1.jdField_b_of_type_JavaLangString))) {
          continue;
        }
        parambcot.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        parambcot.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bcjm(this, parambcot, k, localContext, bool, localSongInfo1, parambcgi));
        return DisplayUtil.dip2px(localContext, 39.0F) + 0;
        i = 0;
        continue;
        j = 0;
      }
    }
    parambcot.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    return 0;
  }
  
  private int a(bcgi parambcgi, bcot parambcot, int paramInt1, int paramInt2)
  {
    if ((parambcot == null) || (parambcgi == null) || (parambcot.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {
      return 0;
    }
    Context localContext = parambcot.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    int i = localContext.getResources().getDisplayMetrics().widthPixels - paramInt1 - paramInt2 - DisplayUtil.dip2px(localContext, 30.0F);
    if ((parambcgi.jdField_a_of_type_JavaUtilArrayList != null) && (parambcgi.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      parambcot.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if ((parambcgi.jdField_a_of_type_Bcgk != null) && (parambcgi.jdField_a_of_type_JavaUtilArrayList != null) && (parambcgi.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        parambcot.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (parambcot.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
          parambcot.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
        }
        if (parambcgi.jdField_a_of_type_Bcgk.jdField_a_of_type_Int == 1)
        {
          if (parambcot.jdField_b_of_type_AndroidWidgetTextView != null) {
            parambcot.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if ((parambcot.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(parambcgi.jdField_a_of_type_Bcgk.jdField_a_of_type_JavaLangString))) {
            break label1007;
          }
          parambcot.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          a(parambcot.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, parambcgi.jdField_a_of_type_Bcgk.jdField_a_of_type_JavaLangString);
          paramInt1 = i - DisplayUtil.dip2px(localContext, 24.0F);
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      if ((parambcot.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(((bcgl)parambcgi.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence)))
      {
        localObject1 = ((bcgl)parambcgi.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence;
        if (!((bcgl)parambcgi.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean) {
          break label635;
        }
        localObject1 = bcnc.a(parambcot.jdField_a_of_type_AndroidWidgetTextView, paramInt1, 1, ((CharSequence)localObject1).toString(), parambcgi.jdField_a_of_type_Bcmr.jdField_a_of_type_JavaUtilList, false, false, true);
        label297:
        parambcot.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (parambcot.c != null) {
          break label677;
        }
        return parambcot.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
        if (parambcgi.jdField_a_of_type_Bcgk.jdField_a_of_type_Int == 2)
        {
          if (parambcot.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
            parambcot.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
          }
          if ((parambcot.jdField_b_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(parambcgi.jdField_a_of_type_Bcgk.jdField_a_of_type_JavaLangCharSequence))) {
            break label1007;
          }
          if (bcnc.e(parambcgi.jdField_a_of_type_Bcgk.jdField_b_of_type_JavaLangString)) {}
          for (localObject1 = parambcgi.jdField_a_of_type_Bcgk.jdField_b_of_type_JavaLangString;; localObject1 = "#fd7f32")
          {
            ((GradientDrawable)parambcot.jdField_b_of_type_AndroidWidgetTextView.getBackground()).setColor(Color.parseColor((String)localObject1));
            parambcot.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            parambcot.jdField_b_of_type_AndroidWidgetTextView.setText(parambcgi.jdField_a_of_type_Bcgk.jdField_a_of_type_JavaLangCharSequence);
            paramInt1 = (int)(i - (bcnc.a(parambcot.jdField_b_of_type_AndroidWidgetTextView, parambcgi.jdField_a_of_type_Bcgk.jdField_a_of_type_JavaLangCharSequence) + DisplayUtil.dip2px(localContext, 10.0F)));
            break;
          }
        }
        if (parambcgi.jdField_a_of_type_Bcgk.jdField_a_of_type_Int != 3) {
          break label1007;
        }
        if (parambcot.jdField_b_of_type_AndroidWidgetTextView != null) {
          parambcot.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if ((parambcot.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(parambcgi.jdField_a_of_type_Bcgk.jdField_a_of_type_JavaLangString))) {
          break label1007;
        }
        parambcot.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
        if ((parambcgi.jdField_a_of_type_Bcgk.jdField_b_of_type_Int > 0) && (parambcgi.jdField_a_of_type_Bcgk.jdField_c_of_type_Int > 0))
        {
          a(parambcot.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, parambcgi.jdField_a_of_type_Bcgk.jdField_b_of_type_Int, parambcgi.jdField_a_of_type_Bcgk.jdField_c_of_type_Int, parambcgi.jdField_a_of_type_Bcgk.jdField_a_of_type_JavaLangString);
          paramInt1 = i - DisplayUtil.dip2px(localContext, DisplayUtil.dip2px(localContext, parambcgi.jdField_a_of_type_Bcgk.jdField_b_of_type_Int) + 4);
          break;
        }
        a(parambcot.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, parambcgi.jdField_a_of_type_Bcgk.jdField_a_of_type_JavaLangString);
        paramInt1 = i - DisplayUtil.dip2px(localContext, 24.0F);
        break;
        label635:
        localObject1 = bcnc.a(parambcot.jdField_a_of_type_AndroidWidgetTextView, paramInt1, ((CharSequence)localObject1).toString());
        break label297;
        if (parambcot.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          parambcot.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
      label677:
      parambcot.c.removeAllViews();
      bcgl localbcgl;
      TextView localTextView;
      if ((parambcgi.jdField_a_of_type_JavaUtilArrayList != null) && (parambcgi.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        while (paramInt1 < parambcgi.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localbcgl = (bcgl)parambcgi.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
          localTextView = new TextView(localContext);
          a(localTextView, localbcgl.jdField_a_of_type_JavaLangString, localbcgl.jdField_a_of_type_Int);
          localObject1 = localbcgl.jdField_a_of_type_JavaLangCharSequence;
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
        paramInt2 = localbcgl.jdField_a_of_type_Int;
        if ((localContext instanceof PublicAcntSearchActivity)) {
          paramInt2 = 1;
        }
        Object localObject2 = localObject1;
        if (localbcgl.jdField_a_of_type_Boolean) {
          if ((!localbcgl.jdField_a_of_type_JavaLangString.equals("A")) && (!localbcgl.jdField_a_of_type_JavaLangString.equals("B"))) {
            break label952;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          localObject2 = bcnc.a(localTextView, i, paramInt2, ((CharSequence)localObject1).toString(), parambcgi.jdField_a_of_type_Bcmr.jdField_a_of_type_JavaUtilList, false, bool, true);
          if (paramInt1 != 0) {
            localTextView.setPadding(0, DisplayUtil.dip2px(localContext, 7.0F - a(((bcgl)parambcgi.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1)).jdField_a_of_type_JavaLangString, localbcgl.jdField_a_of_type_JavaLangString)), 0, 0);
          }
          localTextView.setText((CharSequence)localObject2);
          parambcot.c.addView(localTextView);
          break;
        }
        parambcot.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        b(parambcgi, parambcot);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        parambcot.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
        return parambcot.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
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
      if (!bcnc.e(paramString)) {
        localObject = "#F1F1F1";
      }
    }
  }
  
  public static Pair<Integer, Integer> a(bcfs parambcfs, bcoa parambcoa, boolean paramBoolean, int paramInt)
  {
    if ((parambcoa == null) || (parambcoa.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (parambcoa.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (parambcfs == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "bindUniversalTemplateLeftImageview or item is null");
      }
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    SquareImageView localSquareImageView = parambcoa.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
    bcft localbcft = parambcfs.jdField_a_of_type_Bcft;
    if ((localbcft == null) || (TextUtils.isEmpty(localbcft.jdField_a_of_type_JavaLangString)))
    {
      parambcoa.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    parambcoa.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    Object localObject = localSquareImageView.getContext();
    parambcfs = a(localSquareImageView, localbcft.jdField_a_of_type_Int, localbcft.jdField_a_of_type_JavaLangString, localbcft.jdField_b_of_type_Int, paramBoolean, paramInt, parambcfs);
    paramInt = ((Integer)parambcfs.first).intValue();
    int i = ((Integer)parambcfs.second).intValue();
    parambcfs = localSquareImageView.getLayoutParams();
    parambcfs.width = paramInt;
    parambcfs.height = i;
    localSquareImageView.setLayoutParams(parambcfs);
    parambcfs = (RelativeLayout.LayoutParams)parambcoa.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    parambcfs.width = paramInt;
    parambcfs.height = i;
    parambcoa.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(parambcfs);
    int j = DisplayUtil.dip2px((Context)localObject, 10.0F);
    if ((!TextUtils.isEmpty(localbcft.jdField_a_of_type_JavaLangCharSequence)) && (parambcoa.e != null)) {
      if (bcnc.e(localbcft.jdField_b_of_type_JavaLangString))
      {
        parambcfs = localbcft.jdField_b_of_type_JavaLangString;
        ((GradientDrawable)parambcoa.e.getBackground()).setColor(Color.parseColor(parambcfs));
        parambcoa.e.setVisibility(0);
        parambcoa.e.setText(localbcft.jdField_a_of_type_JavaLangCharSequence);
        label303:
        if (parambcoa.jdField_c_of_type_AndroidWidgetImageView != null)
        {
          if (!localbcft.jdField_a_of_type_Boolean) {
            break label565;
          }
          parambcoa.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        label326:
        if (parambcoa.f != null)
        {
          if (TextUtils.isEmpty(localbcft.jdField_b_of_type_JavaLangCharSequence)) {
            break label577;
          }
          parambcoa.f.setVisibility(0);
          parambcoa.f.setText(localbcft.jdField_b_of_type_JavaLangCharSequence);
        }
        label364:
        if (parambcoa.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView != null)
        {
          if (TextUtils.isEmpty(localbcft.jdField_c_of_type_JavaLangString)) {
            break label589;
          }
          parambcoa.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          parambcfs = URLDrawable.URLDrawableOptions.obtain();
          localObject = new ColorDrawable(-1);
          parambcfs.mFailedDrawable = ((Drawable)localObject);
          parambcfs.mLoadingDrawable = ((Drawable)localObject);
          parambcfs.mRequestWidth = parambcoa.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width;
          parambcfs.mRequestHeight = parambcoa.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height;
          parambcfs = URLDrawable.getDrawable(localbcft.jdField_c_of_type_JavaLangString, parambcfs);
          if ((parambcfs.getStatus() != 1) && (parambcfs.getStatus() != 0)) {
            parambcfs.restartDownload();
          }
          parambcoa.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(parambcfs);
        }
        label481:
        if (parambcoa.g != null)
        {
          if (TextUtils.isEmpty(localbcft.jdField_c_of_type_JavaLangCharSequence)) {
            break label601;
          }
          parambcoa.g.setVisibility(0);
          parambcoa.g.setText(localbcft.jdField_c_of_type_JavaLangCharSequence);
        }
      }
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt + j), Integer.valueOf(i));
      parambcfs = "#fd7f32";
      break;
      if (parambcoa.e == null) {
        break label303;
      }
      parambcoa.e.setVisibility(8);
      break label303;
      label565:
      parambcoa.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label326;
      label577:
      parambcoa.f.setVisibility(8);
      break label364;
      label589:
      parambcoa.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
      break label481;
      label601:
      parambcoa.g.setVisibility(8);
    }
  }
  
  public static Pair<Integer, Integer> a(SquareImageView paramSquareImageView, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, int paramInt3, bcfs parambcfs)
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
          parambcfs = (RelativeLayout.LayoutParams)paramSquareImageView.getLayoutParams();
          i -= DisplayUtil.dip2px((Context)localObject, 3.0F);
          parambcfs.rightMargin = i;
          parambcfs.leftMargin = i;
          parambcfs.topMargin = i;
          paramSquareImageView.setLayoutParams(parambcfs);
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
          parambcfs = URLDrawable.URLDrawableOptions.obtain();
          parambcfs.mRequestWidth = paramInt3;
          parambcfs.mRequestHeight = paramInt1;
          if (j == 0) {
            continue;
          }
          localObject = new GradientDrawable();
          ((GradientDrawable)localObject).setShape(0);
          ((GradientDrawable)localObject).setCornerRadius(paramInt3 / 2.0F);
          ((GradientDrawable)localObject).setColor(-1579033);
          parambcfs.mLoadingDrawable = ((Drawable)localObject);
          parambcfs.mFailedDrawable = ((Drawable)localObject);
          parambcfs.mPlayGifImage = true;
          if (j == 0) {
            continue;
          }
          parambcfs.mMemoryCacheKeySuffix = ("isAvatar" + paramInt3 + paramInt1);
          parambcfs = URLDrawable.getDrawable(paramString, parambcfs);
          parambcfs.setDecodeHandler(bgxc.a);
        }
        catch (Exception parambcfs)
        {
          QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + paramString, parambcfs);
          localObject = localColorDrawable;
          continue;
          parambcfs.mMemoryCacheKeySuffix = ("isNotAvatar" + paramInt3 + paramInt1 + paramInt2);
          parambcfs = URLDrawable.getDrawable(paramString, parambcfs);
          parambcfs.setTag(bgxc.b(paramInt3, paramInt1, paramInt2));
          parambcfs.setDecodeHandler(bgxc.j);
          continue;
        }
        localObject = parambcfs;
        if (parambcfs.getStatus() != 1)
        {
          localObject = parambcfs;
          if (parambcfs.getStatus() != 0)
          {
            parambcfs.restartDownload();
            localObject = parambcfs;
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
        if ((parambcfs instanceof bcgi))
        {
          paramInt1 = DisplayUtil.dip2px((Context)localObject, parambcfs.jdField_a_of_type_Bcft.jdField_c_of_type_Int / 2);
          i = DisplayUtil.dip2px((Context)localObject, parambcfs.jdField_a_of_type_Bcft.d / 2);
        }
        if ((paramInt2 == parambcfs.jdField_a_of_type_Bcft.jdField_c_of_type_Int / 2) && (paramInt2 == parambcfs.jdField_a_of_type_Bcft.d / 2))
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
        parambcfs.mFailedDrawable = localColorDrawable;
        parambcfs.mLoadingDrawable = localColorDrawable;
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131167027));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131167027));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131167028));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131167028));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131167028));
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
      paramTextView.setTextColor(localContext.getResources().getColor(2131167174));
      return;
    }
    paramTextView.setTextSize(1, 17.0F);
    paramTextView.setTextColor(localContext.getResources().getColor(2131167033));
    paramTextView.setIncludeFontPadding(false);
  }
  
  private void a(bcfq parambcfq, bcny parambcny)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3 = parambcny.a().getContext();
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
      parambcny.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      if (!TextUtils.isEmpty(parambcfq.jdField_a_of_type_JavaLangCharSequence)) {
        break label593;
      }
      parambcny.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (parambcfq.jdField_a_of_type_Bcfl == null) {
        break label775;
      }
      parambcny.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      parambcny.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      i = (int)(DeviceInfoUtil.getWidth() - UIUtils.dip2px((Context)localObject3, 30.0F)) / 2 - UIUtils.dip2px((Context)localObject3, 3.0F);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
      localObject2 = URLDrawable.getDrawable(parambcfq.jdField_a_of_type_Bcfl.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
      parambcny.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      localObject2 = (LinearLayout.LayoutParams)parambcny.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = i;
      ((LinearLayout.LayoutParams)localObject2).width = i;
      parambcny.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      parambcny.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (parambcfq.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      m = Math.min(parambcfq.jdField_a_of_type_JavaUtilList.size(), 4);
      n = (i - UIUtils.dip2px((Context)localObject3, 3.0F)) / 2;
      localObject2 = new int[4];
      Object tmp295_293 = localObject2;
      tmp295_293[0] = 2131368535;
      Object tmp301_295 = tmp295_293;
      tmp301_295[1] = 2131368536;
      Object tmp307_301 = tmp301_295;
      tmp307_301[2] = 2131368537;
      Object tmp313_307 = tmp307_301;
      tmp313_307[3] = 2131368538;
      tmp313_307;
      i = 0;
      if (i >= m) {
        break label748;
      }
      localObject3 = (SquareImageView)parambcny.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]);
      localObject4 = ((bcfl)parambcfq.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
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
      if ((i != 3) || (parambcfq.jdField_a_of_type_Int <= 4)) {
        break label731;
      }
      ((SquareImageView)localObject3).setFilterColor(Color.parseColor("#66000000"));
      k = parambcfq.jdField_a_of_type_Int - 4;
      localObject4 = new StringBuilder().append("+");
      j = k;
      if (k > 99) {
        j = 99;
      }
      ((SquareImageView)localObject3).setFilterText(j);
      ((SquareImageView)localObject3).setFilterTextSize(DisplayUtil.dip2px(parambcny.a().getContext(), 20.0F));
    }
    for (;;)
    {
      i += 1;
      break label322;
      parambcny.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      break;
      label593:
      i = (int)(parambcny.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px(parambcny.jdField_a_of_type_AndroidWidgetTextView.getContext(), 30.0F) - bcnc.a(parambcny.jdField_a_of_type_AndroidWidgetTextView, parambcfq.jdField_a_of_type_JavaLangString));
      localObject2 = bcnc.a(parambcny.jdField_a_of_type_AndroidWidgetTextView, i, 1, parambcfq.jdField_a_of_type_JavaLangCharSequence.toString(), parambcfq.jdField_a_of_type_Bcmr.jdField_a_of_type_JavaUtilList, false, false, true);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (parambcfq.jdField_a_of_type_JavaLangString == null) {
        parambcfq.jdField_a_of_type_JavaLangString = "";
      }
      parambcny.jdField_a_of_type_AndroidWidgetTextView.setText(new SpannableStringBuilder((CharSequence)localObject1).append(parambcfq.jdField_a_of_type_JavaLangString));
      parambcny.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break label59;
      label731:
      ((SquareImageView)localObject3).setFilterColor(-1);
      ((SquareImageView)localObject3).setFilterText("");
    }
    label748:
    while (i < 4)
    {
      parambcny.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]).setVisibility(4);
      i += 1;
    }
    label775:
    parambcny.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    parambcny.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (parambcfq.jdField_a_of_type_JavaUtilList != null)
    {
      m = Math.min(parambcfq.jdField_a_of_type_JavaUtilList.size(), parambcny.jdField_a_of_type_Int);
      n = (int)(DeviceInfoUtil.getWidth() - UIUtils.dip2px(parambcny.a().getContext(), (m - 1) * 2 + 27));
      i = 0;
      if (i < m)
      {
        localObject1 = (SquareImageView)parambcny.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        localObject2 = ((bcfl)parambcfq.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
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
        if (parambcfq.jdField_b_of_type_Int != 0)
        {
          ((SquareImageView)localObject1).setImageScale(n / 4 * 1.0F / DisplayUtil.dip2px((Context)localObject3, parambcfq.jdField_b_of_type_Int / 2), 0.0F);
          label1007:
          ((SquareImageView)localObject1).setVisibility(0);
          if ((i != parambcny.jdField_a_of_type_Int - 1) || (parambcfq.jdField_a_of_type_Int <= parambcny.jdField_a_of_type_Int)) {
            break label1136;
          }
          ((SquareImageView)localObject1).setFilterColor(Color.parseColor("#66000000"));
          k = parambcfq.jdField_a_of_type_Int - parambcny.jdField_a_of_type_Int;
          localObject2 = new StringBuilder().append("+");
          j = k;
          if (k > 99) {
            j = 99;
          }
          ((SquareImageView)localObject1).setFilterText(j);
          ((SquareImageView)localObject1).setFilterTextSize(DisplayUtil.dip2px(parambcny.a().getContext(), 20.0F));
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
      while (i < parambcny.jdField_a_of_type_Int)
      {
        parambcny.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(4);
        i += 1;
      }
    }
  }
  
  private void a(bcfr parambcfr, bcnz parambcnz)
  {
    Object localObject = parambcnz.a().getContext();
    int i;
    if (!TextUtils.isEmpty(parambcfr.i))
    {
      parambcnz.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a((Context)localObject, (SquareImageView)parambcnz.jdField_a_of_type_AndroidWidgetImageView, parambcnz.jdField_b_of_type_AndroidWidgetImageView, parambcnz.jdField_b_of_type_AndroidWidgetTextView, parambcfr.jdField_a_of_type_Int, parambcfr.i, parambcfr.jdField_b_of_type_JavaLangString, ((Context)localObject).getResources().getDimensionPixelSize(2131298392));
      i = ((Context)localObject).getResources().getDimensionPixelSize(2131298392);
      if ((parambcfr.jdField_a_of_type_Int == 6) || (parambcfr.jdField_a_of_type_Int == 8)) {
        i = DisplayUtil.dip2px((Context)localObject, 100.0F);
      }
      if (parambcnz.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        break label317;
      }
      i = 0;
      label127:
      float f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px((Context)localObject, 30.0F);
      CharSequence localCharSequence = bcnc.a(parambcnz.jdField_a_of_type_AndroidWidgetTextView, f, 2, parambcfr.jdField_a_of_type_JavaLangCharSequence.toString(), parambcfr.jdField_a_of_type_Bcmr.jdField_a_of_type_JavaUtilList, false, true);
      parambcnz.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
      f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px((Context)localObject, 30.0F) - i;
      localObject = bcnc.a(parambcnz.c, f, 2, parambcfr.jdField_b_of_type_JavaLangCharSequence.toString(), parambcfr.jdField_a_of_type_Bcmr.jdField_a_of_type_JavaUtilList, false, false);
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label333;
      }
      parambcnz.c.setTextColor(Color.parseColor("#4A4A4A"));
      parambcnz.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      a(parambcnz.c, (CharSequence)localObject, true);
      a(parambcnz.jdField_d_of_type_AndroidWidgetTextView, parambcfr.jdField_c_of_type_JavaLangCharSequence);
      return;
      parambcnz.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break;
      label317:
      i += DisplayUtil.dip2px((Context)localObject, 10.0F);
      break label127;
      label333:
      parambcnz.c.setTextColor(Color.parseColor("#737373"));
      parambcnz.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(bcfu parambcfu, bcob parambcob)
  {
    Context localContext = parambcob.a().getContext();
    int j;
    int i;
    if (parambcfu.jdField_a_of_type_Int == 1)
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
        if (!TextUtils.isEmpty(parambcfu.jdField_b_of_type_JavaLangString))
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = k;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          localObject = URLDrawable.getDrawable(parambcfu.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
          parambcob.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
            ((URLDrawable)localObject).restartDownload();
          }
          label164:
          parambcob.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)parambcob.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).height = ((int)(i * UIUtils.getWindowScreenWidth(localContext) * 1.0F / k));
          parambcob.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          parambcob.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
          if (TextUtils.isEmpty(parambcfu.jdField_a_of_type_JavaLangCharSequence)) {
            break label522;
          }
          parambcob.jdField_b_of_type_AndroidWidgetTextView.setText(parambcfu.jdField_a_of_type_JavaLangCharSequence);
          parambcob.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          label253:
          if (TextUtils.isEmpty(parambcfu.jdField_b_of_type_JavaLangCharSequence)) {
            break label534;
          }
          parambcob.c.setText(parambcfu.jdField_b_of_type_JavaLangCharSequence);
          parambcob.c.setVisibility(0);
          label282:
          if (TextUtils.isEmpty(parambcfu.j)) {
            break label599;
          }
          parambcob.jdField_d_of_type_AndroidWidgetTextView.setText(parambcfu.j);
        }
        try
        {
          if (!parambcfu.k.startsWith("#")) {
            parambcfu.k = ("#" + parambcfu.k);
          }
          parambcob.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor(parambcfu.k));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label365:
            parambcob.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#FF00FF00"));
            if (QLog.isColorLevel()) {
              QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bigImageItem.topLeftTagColor = " + parambcfu.k);
            }
          }
        }
        parambcob.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        Object localObject = ((ViewGroup)parambcob.a()).getChildAt(((ViewGroup)parambcob.a()).getChildCount() - 1);
        if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof LinearLayout.LayoutParams)))
        {
          if (parambcfu.b() != 0) {
            break label611;
          }
          ((LinearLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = 0;
          parambcob.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, DisplayUtil.dip2px(localContext, 6.0F));
        }
        label522:
        label534:
        label599:
        label611:
        while (parambcfu.b() != 2)
        {
          return;
          if (parambcfu.jdField_a_of_type_Int == 2)
          {
            j = DisplayUtil.dip2px(localContext, 375.0F);
            i = DisplayUtil.dip2px(localContext, 180.0F);
            break;
          }
          if (parambcfu.jdField_a_of_type_Int != 0) {
            break label639;
          }
          j = DisplayUtil.dip2px(localContext, parambcfu.jdField_a_of_type_Float / 2.0F);
          i = DisplayUtil.dip2px(localContext, parambcfu.jdField_b_of_type_Float / 2.0F);
          break;
          parambcob.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label164;
          parambcob.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label253;
          parambcob.c.setVisibility(8);
          break label282;
          parambcob.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
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
  
  private void a(bcfw parambcfw, bcod parambcod)
  {
    Object localObject1 = parambcod.a().getContext();
    Object localObject2 = parambcod.a();
    if (parambcfw.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.dip2px(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), UIUtils.dip2px(((View)localObject2).getContext(), 6.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131372828);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368597);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.dip2px(((View)localObject2).getContext(), 3.0F), ((View)localObject2).getPaddingRight(), UIUtils.dip2px(((View)localObject2).getContext(), 3.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (parambcfw.jdField_c_of_type_Boolean)
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
    if (!TextUtils.isEmpty(parambcfw.i)) {
      a((Context)localObject1, (SquareImageView)parambcod.b(), parambcod.jdField_b_of_type_AndroidWidgetImageView, parambcod.jdField_a_of_type_AndroidWidgetTextView, parambcfw.jdField_a_of_type_Int, parambcfw.i, null, DisplayUtil.dip2px((Context)localObject1, 32.0F));
    }
    label687:
    Object localObject5;
    if (!TextUtils.isEmpty(parambcfw.jdField_a_of_type_JavaLangString))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = parambcod.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = parambcod.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(parambcfw.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      parambcod.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      parambcod.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298392);
      if ((parambcfw.jdField_a_of_type_Int == 6) || (parambcfw.jdField_a_of_type_Int == 8)) {
        i = DisplayUtil.dip2px((Context)localObject1, 100.0F);
      }
      localObject2 = bcnc.a(parambcod.a(), 10.0F * bcnc.a(parambcod.a(), anvx.a(2131713123)), 1, parambcfw.jdField_a_of_type_JavaLangCharSequence.toString(), parambcfw.jdField_a_of_type_Bcmr.jdField_a_of_type_JavaUtilList, false, false, true);
      parambcod.a().setText((CharSequence)localObject2);
      parambcod.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px((Context)localObject1, 40.0F) - i;
      localObject2 = bcnc.a(parambcod.b(), f1, 2, parambcfw.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(parambcod.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(parambcfw.jdField_c_of_type_JavaLangCharSequence)) {
        break label1047;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px((Context)localObject1, 30.0F);
      localObject2 = bcnc.a(parambcod.c(), f1, 2, parambcfw.jdField_c_of_type_JavaLangCharSequence.toString(), parambcfw.jdField_a_of_type_Bcmr.jdField_a_of_type_JavaUtilList, false, false);
      parambcod.c().setText((CharSequence)localObject2);
      parambcod.c().setVisibility(0);
      if (parambcfw.jdField_a_of_type_JavaUtilList == null) {
        break label1479;
      }
      if (parambcfw.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1071;
      }
      parambcod.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      parambcod.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject3 = parambcod.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject3).getDisplayMetrics().widthPixels;
      }
      localObject2 = parambcod.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject2).setImageScale((float)(1.0D / parambcfw.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject3).getDimension(2131298385);
      float f2 = ((Resources)localObject3).getDimension(2131298385);
      i = DisplayUtil.dip2px(parambcod.a().getContext(), 2.0F);
      j = parambcod.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * parambcfw.jdField_b_of_type_Double);
      j = (int)(j * parambcfw.jdField_b_of_type_Double);
      ((SquareImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      localObject3 = (bcfl)parambcfw.jdField_a_of_type_JavaUtilList.get(0);
      localObject4 = ((bcfl)localObject3).jdField_a_of_type_JavaLangString;
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
      if (((bcfl)localObject3).jdField_a_of_type_Int != 2) {
        break label1059;
      }
      parambcod.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if ((parambcfw.jdField_c_of_type_JavaUtilList != null) || (!TextUtils.equals(parambcfw.k, "0")) || (!TextUtils.equals(parambcfw.m, "0"))) {
        break label1500;
      }
      parambcod.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
      parambcod.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1047:
      parambcod.c().setVisibility(8);
      break label687;
      label1059:
      parambcod.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      label1071:
      parambcod.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      parambcod.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = parambcod.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < parambcfw.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = parambcod.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368597);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131369778);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / parambcfw.jdField_a_of_type_Double), 0.0F);
          localObject4 = (bcfl)parambcfw.jdField_a_of_type_JavaUtilList.get(i);
          localObject5 = ((bcfl)localObject4).jdField_a_of_type_JavaLangString;
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
          if (((bcfl)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1312:
            if ((i != m - 1) || (parambcfw.jdField_b_of_type_Int <= m)) {
              break label1433;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            int k = parambcfw.jdField_b_of_type_Int - m;
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
        parambcod.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
      continue;
      label1479:
      parambcod.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      parambcod.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    label1500:
    if (parambcfw.jdField_c_of_type_JavaUtilList != null)
    {
      parambcod.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      i = parambcfw.jdField_c_of_type_JavaUtilList.size() - 1;
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
      localObject2 = (SquareImageView)LayoutInflater.from((Context)localObject1).inflate(2131559866, null, false);
      localObject3 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px((Context)localObject1, 16.0F), DisplayUtil.dip2px((Context)localObject1, 16.0F));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = j;
      parambcod.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, parambcfw.jdField_c_of_type_JavaUtilList.size() - 1 - i, (ViewGroup.LayoutParams)localObject3);
      localObject3 = (String)parambcfw.jdField_c_of_type_JavaUtilList.get(i);
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((SquareImageView)localObject2).getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = ((SquareImageView)localObject2).getLayoutParams().height;
      localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
      ((URLDrawable)localObject3).setDecodeHandler(bgxc.a);
      ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject3);
      if ((((URLDrawable)localObject3).getStatus() != 1) && (((URLDrawable)localObject3).getStatus() != 0)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      ((SquareImageView)localObject2).setVisibility(0);
      i -= 1;
      break;
      parambcod.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      label1758:
      if (!TextUtils.isEmpty(parambcfw.jdField_b_of_type_JavaLangString))
      {
        parambcod.jdField_b_of_type_AndroidWidgetTextView.setText(parambcfw.jdField_b_of_type_JavaLangString);
        parambcod.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (TextUtils.isEmpty(parambcfw.j)) {
          break label2084;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = parambcod.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = parambcod.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(parambcfw.j, (URLDrawable.URLDrawableOptions)localObject1);
        parambcod.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        parambcod.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        label1900:
        if (TextUtils.isEmpty(parambcfw.k)) {
          break label2096;
        }
        parambcod.c.setText(parambcfw.k);
        parambcod.c.setVisibility(0);
        if (TextUtils.isEmpty(parambcfw.l)) {
          break label2108;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = parambcod.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = parambcod.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(parambcfw.l, (URLDrawable.URLDrawableOptions)localObject1);
        parambcod.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        parambcod.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(parambcfw.m)) {
          break label2120;
        }
        parambcod.jdField_d_of_type_AndroidWidgetTextView.setText(parambcfw.m);
        parambcod.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        parambcod.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        parambcod.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        break label1900;
        parambcod.c.setVisibility(8);
        break label1929;
        parambcod.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      parambcod.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void a(bcgc parambcgc, bcoj parambcoj)
  {
    Object localObject = parambcoj.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(parambcgc.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.dip2px(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.dip2px(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(parambcgc.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      parambcoj.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      parambcoj.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(parambcgc.j)) {
        break label504;
      }
      parambcoj.jdField_a_of_type_AndroidWidgetTextView.setText(parambcgc.j);
      parambcoj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(parambcgc.g)) {
        break label516;
      }
      parambcoj.jdField_b_of_type_AndroidWidgetTextView.setText(parambcgc.g);
      parambcoj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(parambcgc.k)) {
        break label528;
      }
      parambcoj.c.setVisibility(0);
      parambcoj.c.setText(parambcgc.k);
      label262:
      if (TextUtils.isEmpty(parambcgc.l)) {
        break label540;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.dip2px(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.dip2px(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "rightIcon";
      localObject = URLDrawable.getDrawable(parambcgc.l, (URLDrawable.URLDrawableOptions)localObject);
      parambcoj.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      parambcoj.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      label377:
      parambcoj.a(parambcgc);
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label552;
      }
      parambcoj.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839450);
      parambcoj.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839450);
      parambcoj.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      parambcoj.c.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      if (parambcoj.jdField_b_of_type_AndroidWidgetTextView != null) {
        parambcoj.jdField_b_of_type_AndroidWidgetTextView.setTextColor(bcnc.b());
      }
      parambcoj.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new bcji(this, parambcgc, localContext));
      parambcoj.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new bcjj(this, parambcgc, localContext));
      return;
      parambcoj.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label504:
      parambcoj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label516:
      parambcoj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label233;
      label528:
      parambcoj.c.setVisibility(8);
      break label262;
      label540:
      parambcoj.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label377;
      label552:
      parambcoj.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839449);
      parambcoj.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839449);
      parambcoj.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      parambcoj.c.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(bcgd parambcgd, bcol parambcol)
  {
    Object localObject = parambcol.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(parambcgd.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = DisplayUtil.dip2px(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = DisplayUtil.dip2px(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(parambcgd.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      parambcol.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      parambcol.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(parambcgd.j)) {
        break label363;
      }
      parambcol.jdField_a_of_type_AndroidWidgetTextView.setText(parambcgd.j);
      parambcol.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(parambcgd.g)) {
        break label375;
      }
      parambcol.c.setText(parambcgd.g);
      parambcol.c.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(parambcgd.k)) {
        break label387;
      }
      parambcol.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      parambcol.jdField_d_of_type_AndroidWidgetTextView.setText(parambcgd.k);
      label262:
      if (!parambcgd.jdField_b_of_type_Boolean) {
        break label399;
      }
      parambcol.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      bcjs.a(null, 0, parambcgd.jdField_c_of_type_Int, "0X8009D5C", 0, 0, null, null);
      if ((parambcgd.jdField_a_of_type_JavaUtilList != null) && (parambcgd.jdField_a_of_type_JavaUtilList.size() > 0)) {
        bcjs.a(null, 0, parambcgd.jdField_c_of_type_Int, "0X8009D5E", 0, 0, null, null);
      }
      parambcol.a(parambcgd);
      parambcol.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new bcjh(this, parambcgd, localContext));
      return;
      parambcol.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label363:
      parambcol.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label375:
      parambcol.c.setVisibility(8);
      break label233;
      label387:
      parambcol.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label262;
      label399:
      parambcol.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void a(bcgf parambcgf, bcor parambcor)
  {
    if ((parambcgf == null) || (parambcor == null)) {
      return;
    }
    parambcor.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(parambcor.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), 0, parambcor.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), 0);
    Object localObject = (RelativeLayout.LayoutParams)parambcor.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (parambcgf.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localObject = parambcor.jdField_a_of_type_AndroidWidgetTextView.getContext();
      int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px((Context)localObject, 38.0F);
      if (TextUtils.isEmpty(parambcgf.jdField_b_of_type_JavaLangCharSequence)) {
        break label310;
      }
      parambcor.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!bool) {
        break label296;
      }
      parambcor.jdField_b_of_type_AndroidWidgetTextView.setText(parambcgf.jdField_b_of_type_JavaLangCharSequence.toString());
      label148:
      float f1 = i;
      float f2 = bcnc.a(parambcor.jdField_b_of_type_AndroidWidgetTextView, parambcgf.jdField_b_of_type_JavaLangCharSequence);
      i = (int)(f1 - (DisplayUtil.dip2px((Context)localObject, 10.0F) + f2));
      label182:
      if (TextUtils.isEmpty(parambcgf.jdField_a_of_type_JavaLangCharSequence)) {
        break label334;
      }
      parambcor.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = parambcgf.jdField_a_of_type_JavaLangCharSequence;
      if (parambcgf.jdField_b_of_type_Boolean) {
        break label346;
      }
      localObject = bcnc.a(parambcor.jdField_a_of_type_AndroidWidgetTextView, i, (CharSequence)localObject);
    }
    label296:
    label310:
    label334:
    label346:
    for (;;)
    {
      if (bool) {
        parambcor.jdField_a_of_type_AndroidWidgetTextView.setText(((CharSequence)localObject).toString());
      }
      for (;;)
      {
        parambcor.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(a(parambcgf.jdField_a_of_type_JavaLangString));
        parambcor.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bcjk(this, parambcgf, parambcor));
        return;
        ((RelativeLayout.LayoutParams)localObject).addRule(14, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(5);
        break;
        parambcor.jdField_b_of_type_AndroidWidgetTextView.setText(parambcgf.jdField_b_of_type_JavaLangCharSequence);
        break label148;
        parambcor.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label182;
        parambcor.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        continue;
        parambcor.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void a(bcgg parambcgg, bcoq parambcoq)
  {
    if ((parambcgg == null) || (parambcoq == null)) {}
    while ((TextUtils.isEmpty(parambcgg.jdField_a_of_type_JavaLangString)) || (parambcoq.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    Context localContext = parambcoq.jdField_a_of_type_AndroidWidgetTextView.getContext();
    int j = localContext.getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px(localContext, 40.0F);
    int i;
    if ((!TextUtils.isEmpty(parambcgg.e)) && (parambcoq.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      parambcoq.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      i = j - DisplayUtil.dip2px(localContext, 26.0F);
    }
    for (;;)
    {
      parambcgg = bcnc.a(parambcoq.jdField_a_of_type_AndroidWidgetTextView, i, parambcgg.jdField_a_of_type_JavaLangString);
      parambcoq.jdField_a_of_type_AndroidWidgetTextView.setText(parambcgg);
      return;
      i = j;
      if (parambcoq.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        parambcoq.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        i = j;
      }
    }
  }
  
  private void a(bcgi parambcgi, bcot parambcot)
  {
    Context localContext = parambcot.jdField_b_of_type_AndroidWidgetRelativeLayout.getContext();
    Object localObject = (RelativeLayout.LayoutParams)parambcot.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)parambcot.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (parambcgi.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(10, 0);
    }
    for (;;)
    {
      localObject = a(parambcgi, parambcot, false, 0);
      if (((Integer)((Pair)localObject).first).intValue() != 0) {
        ((RelativeLayout.LayoutParams)parambcot.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).rightMargin = DisplayUtil.dip2px(localContext, 10.0F);
      }
      int i = a(parambcgi, parambcot);
      int j = a(parambcgi, parambcot, ((Integer)((Pair)localObject).first).intValue(), i);
      i = j;
      if (((Integer)((Pair)localObject).second).intValue() > j) {
        i = ((Integer)((Pair)localObject).second).intValue();
      }
      if (parambcot.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        ((RelativeLayout.LayoutParams)parambcot.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = i;
      }
      return;
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      localLayoutParams.addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
      localLayoutParams.addRule(15, 0);
    }
  }
  
  private void a(bcgm parambcgm, bcou parambcou)
  {
    Object localObject1 = parambcou.a().getContext();
    Object localObject2 = parambcou.a();
    if (parambcgm.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.dip2px(((View)localObject2).getContext(), 9.0F), ((View)localObject2).getPaddingRight(), UIUtils.dip2px(((View)localObject2).getContext(), 9.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131372828);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368597);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), UIUtils.dip2px(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), UIUtils.dip2px(((View)localObject2).getContext(), 6.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (parambcgm.jdField_c_of_type_Boolean)
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
      parambcou.a().setTextColor(Color.parseColor("#6991B8"));
      parambcou.c().setTextColor(Color.parseColor("#44608A"));
      parambcou.b().setTextColor(Color.parseColor("#44608A"));
      if (!TextUtils.isEmpty(parambcgm.i)) {
        a((Context)localObject1, (SquareImageView)parambcou.b(), parambcou.jdField_b_of_type_AndroidWidgetImageView, parambcou.jdField_a_of_type_AndroidWidgetTextView, parambcgm.jdField_a_of_type_Int, parambcgm.i, null, DisplayUtil.dip2px((Context)localObject1, 21.0F));
      }
      if (TextUtils.isEmpty(parambcgm.jdField_a_of_type_JavaLangString)) {
        break label1085;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = parambcou.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = parambcou.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(parambcgm.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      parambcou.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      parambcou.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298392);
      if ((parambcgm.jdField_a_of_type_Int == 6) || (parambcgm.jdField_a_of_type_Int == 8)) {
        i = DisplayUtil.dip2px((Context)localObject1, 100.0F);
      }
      localObject2 = bcnc.a(parambcou.a(), 10.0F * bcnc.a(parambcou.a(), anvx.a(2131713122)), 1, parambcgm.jdField_a_of_type_JavaLangCharSequence.toString(), parambcgm.jdField_a_of_type_Bcmr.jdField_a_of_type_JavaUtilList, false, false, true);
      parambcou.a().setText((CharSequence)localObject2);
      parambcou.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px((Context)localObject1, 40.0F) - i;
      localObject2 = bcnc.a(parambcou.b(), f1, 2, parambcgm.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(parambcou.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(parambcgm.jdField_c_of_type_JavaLangCharSequence)) {
        break label1097;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - DisplayUtil.dip2px((Context)localObject1, 30.0F);
      localObject2 = bcnc.a(parambcou.c(), f1, 2, parambcgm.jdField_c_of_type_JavaLangCharSequence.toString(), parambcgm.jdField_a_of_type_Bcmr.jdField_a_of_type_JavaUtilList, false, false);
      parambcou.c().setText((CharSequence)localObject2);
      parambcou.c().setVisibility(0);
      label740:
      if (parambcgm.jdField_a_of_type_JavaUtilList == null) {
        break label1546;
      }
      if (parambcgm.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1119;
      }
      parambcou.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      parambcou.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject2 = parambcou.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject2).getDisplayMetrics().widthPixels;
      }
      localObject1 = parambcou.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject1).setImageScale((float)(1.0D / parambcgm.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject2).getDimension(2131298385);
      float f2 = ((Resources)localObject2).getDimension(2131298385);
      i = DisplayUtil.dip2px(parambcou.a().getContext(), 2.0F);
      j = parambcou.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * parambcgm.jdField_b_of_type_Double);
      j = (int)(j * parambcgm.jdField_b_of_type_Double);
      ((SquareImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      parambcgm = (bcfl)parambcgm.jdField_a_of_type_JavaUtilList.get(0);
      localObject2 = parambcgm.jdField_a_of_type_JavaLangString;
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
      if (parambcgm.jdField_a_of_type_Int != 2) {
        break label1109;
      }
      parambcou.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      return;
      parambcou.a().setTextColor(Color.parseColor("#262626"));
      parambcou.c().setTextColor(Color.parseColor("#737373"));
      parambcou.b().setTextColor(Color.parseColor("#737373"));
      break;
      label1085:
      parambcou.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label496;
      label1097:
      parambcou.c().setVisibility(8);
      break label740;
      label1109:
      parambcou.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      label1119:
      parambcou.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      parambcou.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = parambcou.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < parambcgm.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = parambcou.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368597);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131369778);
          j = UIUtils.getWindowScreenWidth((Context)localObject1) / m;
          int k = (int)(j * parambcgm.jdField_a_of_type_Double);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / parambcgm.jdField_a_of_type_Double), 0.0F);
          localObject4 = (bcfl)parambcgm.jdField_a_of_type_JavaUtilList.get(i);
          Object localObject5 = ((bcfl)localObject4).jdField_a_of_type_JavaLangString;
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
          if (((bcfl)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1379:
            if ((i != m - 1) || (parambcgm.jdField_b_of_type_Int <= m)) {
              break label1500;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            k = parambcgm.jdField_b_of_type_Int - m;
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
        parambcou.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
    }
    label1546:
    parambcou.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    parambcou.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
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
  
  private void b(bcgi parambcgi, bcot parambcot)
  {
    if ((parambcgi == null) || (parambcgi.jdField_a_of_type_Bcgj == null) || (parambcot == null)) {
      if ((parambcot != null) && (parambcot.jdField_b_of_type_AndroidWidgetButton != null)) {
        parambcot.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
    while (parambcot.jdField_b_of_type_AndroidWidgetButton == null) {
      return;
    }
    Context localContext = parambcot.jdField_b_of_type_AndroidWidgetButton.getContext();
    if ((parambcgi.jdField_a_of_type_Bcgj.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(parambcgi.jdField_a_of_type_Bcgj.jdField_a_of_type_JavaLangCharSequence)))
    {
      parambcot.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      parambcot.jdField_b_of_type_AndroidWidgetButton.setText(parambcgi.jdField_a_of_type_Bcgj.jdField_a_of_type_JavaLangCharSequence);
      parambcot.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new bcjn(this, localContext, parambcgi));
      return;
    }
    parambcot.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
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
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130842369, false);
      return;
    case 4: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130842369, false);
      return;
    case 5: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, true);
      return;
    case 6: 
      paramInt1 = DisplayUtil.dip2px(paramContext, 62.0F);
      a(paramSquareImageView, paramImageView, paramTextView, DisplayUtil.dip2px(paramContext, 100.0F), paramInt1, false, paramString1, null, 2130842369, false);
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
  
  public void a(bcfs parambcfs, bcoa parambcoa)
  {
    bcnf.a(parambcfs.a(), parambcfs.b(), parambcoa.a(), parambcfs.jdField_a_of_type_Boolean, parambcfs.u, parambcfs.g);
    switch (parambcfs.d())
    {
    }
    for (;;)
    {
      b(parambcfs, parambcoa);
      if (TextUtils.isEmpty(parambcfs.i)) {
        c(parambcfs, parambcoa);
      }
      return;
      a((bcfq)parambcfs, (bcny)parambcoa);
      continue;
      a((bcgm)parambcfs, (bcou)parambcoa);
      continue;
      a((bcfr)parambcfs, (bcnz)parambcoa);
      continue;
      a((bcfz)parambcfs, (bcog)parambcoa);
      continue;
      a((bcgi)parambcfs, (bcot)parambcoa);
      continue;
      a((bcgf)parambcfs, (bcor)parambcoa);
      continue;
      a((bcgg)parambcfs, (bcoq)parambcoa);
      continue;
      a((bcfw)parambcfs, (bcod)parambcoa);
      continue;
      a((bcfu)parambcfs, (bcob)parambcoa);
      continue;
      a((bcfx)parambcfs, (bcoe)parambcoa);
      continue;
      a((bcgh)parambcfs, (bcos)parambcoa);
      continue;
      a((bcge)parambcfs, (bcoo)parambcoa);
      continue;
      a((bcgc)parambcfs, (bcoj)parambcoa);
      continue;
      a((bcgd)parambcfs, (bcol)parambcoa);
      continue;
      a((bcgb)parambcfs, (bcoi)parambcoa);
    }
  }
  
  public void a(bcfs parambcfs, bcoa parambcoa, Bitmap paramBitmap)
  {
    if (parambcoa.b() != null) {
      parambcoa.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(bcfx parambcfx, bcoe parambcoe)
  {
    if ((parambcfx.jdField_a_of_type_JavaUtilArrayList == null) || (parambcfx.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorSlidingContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
      return;
    }
    bcbg localbcbg2 = (bcbg)parambcoe.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter();
    bcbg localbcbg1;
    if (localbcbg2 != null)
    {
      localbcbg1 = localbcbg2;
      if (localbcbg2.a() == parambcfx.jdField_a_of_type_JavaUtilArrayList) {}
    }
    else
    {
      localbcbg1 = new bcbg(parambcfx, this.jdField_a_of_type_Bcbf.jdField_b_of_type_Int, parambcoe.jdField_a_of_type_ComTencentWidgetHorizontalListView);
      parambcoe.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(localbcbg1);
    }
    if (localbcbg1.a() != parambcfx.jdField_a_of_type_JavaUtilArrayList)
    {
      parambcoe.jdField_a_of_type_Bcfx = parambcfx;
      parambcoe.jdField_a_of_type_ComTencentWidgetHorizontalListView.resetCurrentX(parambcfx.jdField_b_of_type_Int);
    }
    localbcbg1.a(parambcfx.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(bcfz parambcfz, bcog parambcog)
  {
    parambcog.a().getContext();
    parambcog.a();
    if ((parambcfz.jdField_a_of_type_JavaUtilArrayList == null) || (parambcfz.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
    }
    for (;;)
    {
      return;
      parambcog.a(parambcfz);
      if (parambcfz.jdField_a_of_type_JavaUtilArrayList.size() != parambcog.jdField_a_of_type_JavaUtilArrayList.size()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, view.size != model.size");
      }
      int j = parambcfz.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((bcfy)parambcfz.jdField_a_of_type_JavaUtilArrayList.get(i)).a((bcof)parambcog.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
    }
  }
  
  protected void a(bcgb parambcgb, bcoi parambcoi)
  {
    Object localObject1 = (LinearLayout)parambcoi.b();
    bcfo localbcfo;
    Object localObject2;
    bcnw localbcnw;
    if ((localObject1 != null) && (parambcgb.a != null))
    {
      ((LinearLayout)localObject1).removeAllViews();
      if (((LinearLayout)localObject1).getParent() != null) {
        ((View)((LinearLayout)localObject1).getParent()).setPadding(0, 0, 0, 0);
      }
      localbcfo = parambcgb.a;
      parambcgb = parambcoi.a().getContext();
      localObject2 = LayoutInflater.from(parambcgb).inflate(2131562833, null);
      localbcnw = new bcnw((View)localObject2);
      Object localObject3 = ((View)localObject2).findViewById(2131369049);
      int i = ViewUtils.dip2px(6.0F);
      ((View)localObject3).setPadding(0, i, 0, i);
      ((LinearLayout)localObject1).addView((View)localObject2);
      if (localbcfo.c() != null) {
        break label620;
      }
      if (localbcnw.c() != null) {
        localbcnw.c().setVisibility(8);
      }
      if (localbcnw.a() != null) {
        localbcnw.a().setVisibility(8);
      }
      localObject1 = localbcnw.a();
      if (localObject1 != null) {
        ((URLImageView)localObject1).setVisibility(8);
      }
      localObject1 = localbcnw.e();
      if (localObject1 != null)
      {
        ((TextView)localObject1).setVisibility(0);
        if (!TextUtils.isEmpty(localbcfo.a())) {
          ((TextView)localObject1).setText(localbcfo.a());
        }
      }
      if ((localbcnw.b() != null) && (!TextUtils.isEmpty(localbcfo.g())))
      {
        localObject1 = localbcfo.g();
        localObject2 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = DisplayUtil.dip2px(parambcgb, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = DisplayUtil.dip2px(parambcgb, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
        if (!bkyp.a((String)localObject1)) {
          break label745;
        }
        localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
        ((URLDrawable)localObject1).setTag(bgxc.b(DisplayUtil.dip2px(parambcgb, 50.0F), DisplayUtil.dip2px(parambcoi.a().getContext(), 50.0F), DisplayUtil.dip2px(parambcgb, 3.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(bgxc.j);
        localbcnw.b().setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
      }
      label397:
      localbcnw.a().setOnClickListener(new bcjg(this, localbcfo));
      if ((localbcnw.a() != null) && (localbcfo.c()))
      {
        parambcoi = localbcfo.h();
        localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = DisplayUtil.dip2px(parambcgb, 40.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = DisplayUtil.dip2px(parambcgb, 12.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        parambcoi = URLDrawable.getDrawable(parambcoi, (URLDrawable.URLDrawableOptions)localObject2);
        parambcoi.setTag(bgxc.b(DisplayUtil.dip2px(parambcgb, 38.0F), DisplayUtil.dip2px(parambcgb, 12.0F), 0));
        parambcoi.setDecodeHandler(bgxc.j);
        localbcnw.a().setImageDrawable(parambcoi);
        if ((parambcoi.getStatus() != 1) && (parambcoi.getStatus() != 0)) {
          parambcoi.restartDownload();
        }
      }
      parambcgb = new MiniAppInfo();
      parambcgb.appId = localbcfo.a.appId;
      parambcoi = new MiniAppConfig(parambcgb);
      if (localbcfo.a.showMask != 1) {
        break label758;
      }
    }
    label620:
    label758:
    for (parambcgb = "used";; parambcgb = "unused")
    {
      MiniProgramLpReportDC04239.reportAsync(parambcoi, "search", "result_view", parambcgb, localbcfo.a());
      return;
      if ((localbcnw.c() != null) && (!TextUtils.isEmpty(localbcfo.c())))
      {
        localbcnw.c().setVisibility(0);
        localbcnw.c().setText(localbcfo.c());
      }
      for (;;)
      {
        if (localbcnw.a() != null) {
          localbcnw.a().setVisibility(0);
        }
        localObject1 = localbcnw.e();
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        if (TextUtils.isEmpty(localbcfo.a())) {
          break;
        }
        localbcnw.a().setText(localbcfo.a());
        break;
        if (localbcnw.c() != null) {
          localbcnw.c().setVisibility(8);
        }
      }
      localbcnw.b().setImageDrawable((Drawable)localObject2);
      break label397;
    }
  }
  
  protected void a(bcge parambcge, bcoo parambcoo)
  {
    Object localObject1 = parambcoo.a().getContext();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      parambcoo.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      parambcoo.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
      if (TextUtils.isEmpty(parambcge.jdField_b_of_type_JavaLangString)) {
        break label290;
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = DisplayUtil.dip2px((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = DisplayUtil.dip2px((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "askIcon";
      localObject2 = URLDrawable.getDrawable(parambcge.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      parambcoo.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      parambcoo.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    label290:
    for (;;)
    {
      label166:
      if (!TextUtils.isEmpty(parambcge.j))
      {
        int j = parambcoo.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
        int i = (int)bcnc.a(parambcoo.jdField_a_of_type_AndroidWidgetTextView, " ");
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
            parambcoo.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
            parambcoo.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
            break;
            parambcoo.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            break label166;
          }
        }
        localObject1 = bcnc.a(parambcoo.jdField_a_of_type_AndroidWidgetTextView, j, 2, (String)localObject1 + parambcge.j, parambcge.jdField_a_of_type_Bcmr.jdField_a_of_type_JavaUtilList, false, false, true);
        parambcoo.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
    }
    parambcoo.a(parambcge);
    if ((!TextUtils.isEmpty(parambcge.k)) && (parambcge.jdField_a_of_type_JavaUtilList != null) && (parambcge.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      parambcoo.jdField_b_of_type_AndroidWidgetTextView.setText(parambcge.k);
      parambcoo.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    parambcoo.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void a(bcgh parambcgh, bcos parambcos)
  {
    if (!TextUtils.isEmpty(parambcgh.jdField_b_of_type_JavaLangString))
    {
      parambcos.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = parambcos.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = parambcos.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
      localObject = URLDrawable.getDrawable(parambcgh.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      parambcos.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      if (TextUtils.isEmpty(parambcgh.j)) {
        break label345;
      }
      parambcos.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      int i = parambcos.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
      localObject = bcnc.a(parambcos.jdField_a_of_type_AndroidWidgetTextView, i, 1, parambcgh.j, parambcgh.jdField_a_of_type_Bcmr.jdField_a_of_type_JavaUtilList, false, false, true);
      parambcos.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label183:
      if (TextUtils.isEmpty(parambcgh.l)) {
        break label357;
      }
      parambcos.jdField_b_of_type_AndroidWidgetTextView.setText(parambcgh.l);
      parambcos.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      parambcos.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label220:
      if (TextUtils.isEmpty(parambcgh.k)) {
        break label378;
      }
      parambcos.c.setText(parambcgh.k);
      parambcos.c.setVisibility(0);
    }
    for (;;)
    {
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label390;
      }
      parambcos.jdField_a_of_type_AndroidWidgetTextView.setTextColor(parambcos.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166959));
      parambcos.c.setTextColor(parambcos.c.getContext().getResources().getColor(2131166958));
      parambcos.jdField_b_of_type_AndroidWidgetTextView.setTextColor(parambcos.jdField_b_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166958));
      return;
      parambcos.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label345:
      parambcos.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label183;
      label357:
      parambcos.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      parambcos.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label220;
      label378:
      parambcos.c.setVisibility(8);
    }
    label390:
    parambcos.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
    parambcos.c.setTextColor(Color.parseColor("#737373"));
    parambcos.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
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
          paramTextView.setDecodeHandler(bgxc.a);
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
  
  protected void b(bcfs parambcfs, bcoa parambcoa)
  {
    if (parambcoa.a() != null) {
      parambcoa.a().setOnClickListener(new bcjf(this, parambcfs));
    }
  }
  
  public void c(bcfs parambcfs, bcoa parambcoa)
  {
    if ((parambcoa.b() != null) && ((parambcfs instanceof bcfg)) && (!TextUtils.isEmpty(parambcfs.b()))) {
      parambcoa.b().setImageDrawable(bcnc.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, parambcfs));
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
      bcnc.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localImageView.post(new SearchTemplatePresenter.11(this, localImageView, bool));
      localImageView.setContentDescription(localResources.getString(2131690231));
      this.jdField_a_of_type_Bcbf.notifyDataSetChanged();
      return;
    }
    localImageView.post(new SearchTemplatePresenter.12(this, localImageView, bool));
    localImageView.setContentDescription(localResources.getString(2131690229));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcje
 * JD-Core Version:    0.7.0.1
 */