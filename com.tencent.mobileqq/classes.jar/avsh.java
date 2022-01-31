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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.10;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.11;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.12;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class avsh
  implements arzq, avrh<avow, avxd>
{
  public static int a;
  private long jdField_a_of_type_Long;
  public ColorDrawable a;
  public Drawable a;
  private avkm jdField_a_of_type_Avkm;
  private azwg jdField_a_of_type_Azwg;
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  
  public avsh(azwg paramazwg, avkm paramavkm)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = axwd.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_a_of_type_Azwg = paramazwg;
    this.jdField_a_of_type_Avkm = paramavkm;
  }
  
  private float a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 7.0F;
    }
    return 3.5F;
  }
  
  private int a(avpm paramavpm, avxw paramavxw)
  {
    if ((paramavpm == null) || (paramavpm.jdField_a_of_type_Avpn == null) || (paramavxw == null) || (paramavxw.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      if ((paramavxw != null) && (paramavxw.jdField_a_of_type_AndroidWidgetButton != null)) {
        paramavxw.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((paramavxw != null) && (paramavxw.jdField_a_of_type_AndroidWidgetImageView != null)) {
        paramavxw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    if (paramavpm.jdField_a_of_type_Avpn.jdField_a_of_type_Int == 1)
    {
      if (paramavxw.jdField_a_of_type_AndroidWidgetButton != null) {
        paramavxw.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if (paramavxw.jdField_a_of_type_AndroidWidgetImageView != null) {
        paramavxw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return 0;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    Context localContext = paramavxw.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext();
    int i;
    if (paramavpm.jdField_a_of_type_Avpn.jdField_a_of_type_Int == 2)
    {
      if (paramavxw.jdField_a_of_type_AndroidWidgetImageView != null) {
        paramavxw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (paramavxw.jdField_a_of_type_AndroidWidgetButton == null) {
        return 0;
      }
      if (!TextUtils.isEmpty(paramavpm.jdField_a_of_type_Avpn.jdField_a_of_type_JavaLangCharSequence))
      {
        paramavxw.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramavxw.jdField_a_of_type_AndroidWidgetButton.setText(paramavpm.jdField_a_of_type_Avpn.jdField_a_of_type_JavaLangCharSequence);
        paramavxw.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new avso(this, localContext, paramavpm));
      }
      for (;;)
      {
        i = (int)(0 + (avwf.a(paramavxw.jdField_a_of_type_AndroidWidgetButton, paramavpm.jdField_a_of_type_Avpn.jdField_a_of_type_JavaLangCharSequence) + azvv.a(localContext, 32.0F) + azvv.a(localContext, 15.0F)));
        if (!bool) {
          break;
        }
        paramavxw.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842612);
        paramavxw.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#6991B8"));
        return i;
        paramavxw.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      paramavxw.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842611);
      paramavxw.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#000000"));
      return i;
    }
    int j;
    if (paramavpm.jdField_a_of_type_Avpn.jdField_a_of_type_Int == 3)
    {
      if (paramavxw.jdField_a_of_type_AndroidWidgetButton != null) {
        paramavxw.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if ((paramavxw.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (paramavxw.jdField_a_of_type_AndroidWidgetImageView == null)) {
        return 0;
      }
      int k = ((Integer)paramavxw.a().getTag(2131313374)).intValue();
      SongInfo localSongInfo1 = new SongInfo();
      i = 0;
      j = i;
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramavpm.h);
          j = i;
          localSongInfo1.jdField_a_of_type_JavaLangString = localJSONObject.optString("audio_url");
          j = i;
          localSongInfo1.jdField_b_of_type_JavaLangString = localJSONObject.optString("title");
          j = i;
          localSongInfo1.jdField_c_of_type_JavaLangString = localJSONObject.optString("desc");
          j = i;
          localSongInfo1.d = localJSONObject.optString("image_url");
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
          avwf.jdField_a_of_type_Long = localSongInfo2.jdField_a_of_type_Long;
          continue;
          paramavxw.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848345);
          continue;
          if (this.jdField_a_of_type_Long != avwf.jdField_a_of_type_Long) {
            continue;
          }
          paramavxw.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848346);
          continue;
          paramavxw.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848344);
          continue;
          paramavxw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
        }
        this.jdField_a_of_type_Long = localSongInfo1.jdField_a_of_type_Long;
        QQPlayerService.a(this);
        if (QQPlayerService.a() == 2) {
          continue;
        }
        avwf.jdField_a_of_type_Long = -1L;
        if (!bool) {
          continue;
        }
        if (this.jdField_a_of_type_Long != avwf.jdField_a_of_type_Long) {
          continue;
        }
        paramavxw.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848347);
        if ((j == 0) || (i == 0) || (TextUtils.isEmpty(localSongInfo1.jdField_a_of_type_JavaLangString))) {
          continue;
        }
        paramavxw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramavxw.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new avsp(this, paramavxw, k, localContext, bool, localSongInfo1, paramavpm));
        return azvv.a(localContext, 39.0F) + 0;
        i = 0;
        continue;
        j = 0;
      }
    }
    paramavxw.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    return 0;
  }
  
  private int a(avpm paramavpm, avxw paramavxw, int paramInt1, int paramInt2)
  {
    if ((paramavxw == null) || (paramavpm == null) || (paramavxw.jdField_a_of_type_AndroidWidgetLinearLayout == null)) {
      return 0;
    }
    Context localContext = paramavxw.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
    int i = localContext.getResources().getDisplayMetrics().widthPixels - paramInt1 - paramInt2 - azvv.a(localContext, 30.0F);
    if ((paramavpm.jdField_a_of_type_JavaUtilArrayList != null) && (paramavpm.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramavxw.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if ((paramavpm.jdField_a_of_type_Avpo != null) && (paramavpm.jdField_a_of_type_JavaUtilArrayList != null) && (paramavpm.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        paramavxw.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (paramavxw.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
          paramavxw.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
        }
        if (paramavpm.jdField_a_of_type_Avpo.jdField_a_of_type_Int == 1)
        {
          if (paramavxw.jdField_b_of_type_AndroidWidgetTextView != null) {
            paramavxw.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if ((paramavxw.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(paramavpm.jdField_a_of_type_Avpo.jdField_a_of_type_JavaLangString))) {
            break label1007;
          }
          paramavxw.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          a(paramavxw.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramavpm.jdField_a_of_type_Avpo.jdField_a_of_type_JavaLangString);
          paramInt1 = i - azvv.a(localContext, 24.0F);
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      if ((paramavxw.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(((avpp)paramavpm.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence)))
      {
        localObject1 = ((avpp)paramavpm.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangCharSequence;
        if (!((avpp)paramavpm.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Boolean) {
          break label635;
        }
        localObject1 = avwf.a(paramavxw.jdField_a_of_type_AndroidWidgetTextView, paramInt1, 1, ((CharSequence)localObject1).toString(), paramavpm.jdField_a_of_type_Avvu.jdField_a_of_type_JavaUtilList, false, false, true);
        label297:
        paramavxw.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramavxw.c != null) {
          break label677;
        }
        return paramavxw.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
        if (paramavpm.jdField_a_of_type_Avpo.jdField_a_of_type_Int == 2)
        {
          if (paramavxw.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null) {
            paramavxw.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
          }
          if ((paramavxw.jdField_b_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(paramavpm.jdField_a_of_type_Avpo.jdField_a_of_type_JavaLangCharSequence))) {
            break label1007;
          }
          if (avwf.d(paramavpm.jdField_a_of_type_Avpo.jdField_b_of_type_JavaLangString)) {}
          for (localObject1 = paramavpm.jdField_a_of_type_Avpo.jdField_b_of_type_JavaLangString;; localObject1 = "#fd7f32")
          {
            ((GradientDrawable)paramavxw.jdField_b_of_type_AndroidWidgetTextView.getBackground()).setColor(Color.parseColor((String)localObject1));
            paramavxw.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramavxw.jdField_b_of_type_AndroidWidgetTextView.setText(paramavpm.jdField_a_of_type_Avpo.jdField_a_of_type_JavaLangCharSequence);
            paramInt1 = (int)(i - (avwf.a(paramavxw.jdField_b_of_type_AndroidWidgetTextView, paramavpm.jdField_a_of_type_Avpo.jdField_a_of_type_JavaLangCharSequence) + azvv.a(localContext, 10.0F)));
            break;
          }
        }
        if (paramavpm.jdField_a_of_type_Avpo.jdField_a_of_type_Int != 3) {
          break label1007;
        }
        if (paramavxw.jdField_b_of_type_AndroidWidgetTextView != null) {
          paramavxw.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if ((paramavxw.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (TextUtils.isEmpty(paramavpm.jdField_a_of_type_Avpo.jdField_a_of_type_JavaLangString))) {
          break label1007;
        }
        paramavxw.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
        if ((paramavpm.jdField_a_of_type_Avpo.jdField_b_of_type_Int > 0) && (paramavpm.jdField_a_of_type_Avpo.jdField_c_of_type_Int > 0))
        {
          a(paramavxw.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramavpm.jdField_a_of_type_Avpo.jdField_b_of_type_Int, paramavpm.jdField_a_of_type_Avpo.jdField_c_of_type_Int, paramavpm.jdField_a_of_type_Avpo.jdField_a_of_type_JavaLangString);
          paramInt1 = i - azvv.a(localContext, azvv.a(localContext, paramavpm.jdField_a_of_type_Avpo.jdField_b_of_type_Int) + 4);
          break;
        }
        a(paramavxw.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, paramavpm.jdField_a_of_type_Avpo.jdField_a_of_type_JavaLangString);
        paramInt1 = i - azvv.a(localContext, 24.0F);
        break;
        label635:
        localObject1 = avwf.a(paramavxw.jdField_a_of_type_AndroidWidgetTextView, paramInt1, ((CharSequence)localObject1).toString());
        break label297;
        if (paramavxw.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          paramavxw.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
      }
      label677:
      paramavxw.c.removeAllViews();
      avpp localavpp;
      TextView localTextView;
      if ((paramavpm.jdField_a_of_type_JavaUtilArrayList != null) && (paramavpm.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        while (paramInt1 < paramavpm.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localavpp = (avpp)paramavpm.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
          localTextView = new TextView(localContext);
          a(localTextView, localavpp.jdField_a_of_type_JavaLangString, localavpp.jdField_a_of_type_Int);
          localObject1 = localavpp.jdField_a_of_type_JavaLangCharSequence;
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
        paramInt2 = localavpp.jdField_a_of_type_Int;
        if ((localContext instanceof PublicAcntSearchActivity)) {
          paramInt2 = 1;
        }
        Object localObject2 = localObject1;
        if (localavpp.jdField_a_of_type_Boolean) {
          if ((!localavpp.jdField_a_of_type_JavaLangString.equals("A")) && (!localavpp.jdField_a_of_type_JavaLangString.equals("B"))) {
            break label952;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          localObject2 = avwf.a(localTextView, i, paramInt2, ((CharSequence)localObject1).toString(), paramavpm.jdField_a_of_type_Avvu.jdField_a_of_type_JavaUtilList, false, bool, true);
          if (paramInt1 != 0) {
            localTextView.setPadding(0, azvv.a(localContext, 7.0F - a(((avpp)paramavpm.jdField_a_of_type_JavaUtilArrayList.get(paramInt1 - 1)).jdField_a_of_type_JavaLangString, localavpp.jdField_a_of_type_JavaLangString)), 0, 0);
          }
          localTextView.setText((CharSequence)localObject2);
          paramavxw.c.addView(localTextView);
          break;
        }
        paramavxw.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        b(paramavpm, paramavxw);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramavxw.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
        return paramavxw.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
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
      if (!avwf.d(paramString)) {
        localObject = "#F1F1F1";
      }
    }
  }
  
  public static Pair<Integer, Integer> a(avow paramavow, avxd paramavxd, boolean paramBoolean, int paramInt)
  {
    if ((paramavxd == null) || (paramavxd.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (paramavxd.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView == null) || (paramavow == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "bindUniversalTemplateLeftImageview or item is null");
      }
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    SquareImageView localSquareImageView = paramavxd.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView;
    avox localavox = paramavow.jdField_a_of_type_Avox;
    if ((localavox == null) || (TextUtils.isEmpty(localavox.jdField_a_of_type_JavaLangString)))
    {
      paramavxd.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    paramavxd.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    Object localObject = localSquareImageView.getContext();
    paramavow = a(localSquareImageView, localavox.jdField_a_of_type_Int, localavox.jdField_a_of_type_JavaLangString, localavox.jdField_b_of_type_Int, paramBoolean, paramInt, paramavow);
    paramInt = ((Integer)paramavow.first).intValue();
    int i = ((Integer)paramavow.second).intValue();
    paramavow = localSquareImageView.getLayoutParams();
    paramavow.width = paramInt;
    paramavow.height = i;
    localSquareImageView.setLayoutParams(paramavow);
    paramavow = (RelativeLayout.LayoutParams)paramavxd.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramavow.width = paramInt;
    paramavow.height = i;
    paramavxd.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramavow);
    int j = azvv.a((Context)localObject, 10.0F);
    if ((!TextUtils.isEmpty(localavox.jdField_a_of_type_JavaLangCharSequence)) && (paramavxd.e != null)) {
      if (avwf.d(localavox.jdField_b_of_type_JavaLangString))
      {
        paramavow = localavox.jdField_b_of_type_JavaLangString;
        ((GradientDrawable)paramavxd.e.getBackground()).setColor(Color.parseColor(paramavow));
        paramavxd.e.setVisibility(0);
        paramavxd.e.setText(localavox.jdField_a_of_type_JavaLangCharSequence);
        label303:
        if (paramavxd.jdField_c_of_type_AndroidWidgetImageView != null)
        {
          if (!localavox.jdField_a_of_type_Boolean) {
            break label565;
          }
          paramavxd.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        label326:
        if (paramavxd.f != null)
        {
          if (TextUtils.isEmpty(localavox.jdField_b_of_type_JavaLangCharSequence)) {
            break label577;
          }
          paramavxd.f.setVisibility(0);
          paramavxd.f.setText(localavox.jdField_b_of_type_JavaLangCharSequence);
        }
        label364:
        if (paramavxd.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView != null)
        {
          if (TextUtils.isEmpty(localavox.jdField_c_of_type_JavaLangString)) {
            break label589;
          }
          paramavxd.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(0);
          paramavow = URLDrawable.URLDrawableOptions.obtain();
          localObject = new ColorDrawable(-1);
          paramavow.mFailedDrawable = ((Drawable)localObject);
          paramavow.mLoadingDrawable = ((Drawable)localObject);
          paramavow.mRequestWidth = paramavxd.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width;
          paramavow.mRequestHeight = paramavxd.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height;
          paramavow = URLDrawable.getDrawable(localavox.jdField_c_of_type_JavaLangString, paramavow);
          if ((paramavow.getStatus() != 1) && (paramavow.getStatus() != 0)) {
            paramavow.restartDownload();
          }
          paramavxd.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(paramavow);
        }
        label481:
        if (paramavxd.g != null)
        {
          if (TextUtils.isEmpty(localavox.jdField_c_of_type_JavaLangCharSequence)) {
            break label601;
          }
          paramavxd.g.setVisibility(0);
          paramavxd.g.setText(localavox.jdField_c_of_type_JavaLangCharSequence);
        }
      }
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt + j), Integer.valueOf(i));
      paramavow = "#fd7f32";
      break;
      if (paramavxd.e == null) {
        break label303;
      }
      paramavxd.e.setVisibility(8);
      break label303;
      label565:
      paramavxd.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label326;
      label577:
      paramavxd.f.setVisibility(8);
      break label364;
      label589:
      paramavxd.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView.setVisibility(8);
      break label481;
      label601:
      paramavxd.g.setVisibility(8);
    }
  }
  
  public static Pair<Integer, Integer> a(SquareImageView paramSquareImageView, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, int paramInt3, avow paramavow)
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
      paramInt1 = azvv.a((Context)localObject, 60.0F);
      i = azvv.a((Context)localObject, 60.0F);
      j = 0;
      localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      if (paramBoolean)
      {
        paramInt1 = (int)(i * 1.0F / paramInt1 * paramInt3);
        if (j != 0)
        {
          i = (int)(paramInt3 * 0.2D / 2.0D);
          paramSquareImageView.setPadding(azvv.a((Context)localObject, 3.0F), azvv.a((Context)localObject, 3.0F), azvv.a((Context)localObject, 3.0F), azvv.a((Context)localObject, 3.0F));
          paramavow = (RelativeLayout.LayoutParams)paramSquareImageView.getLayoutParams();
          i -= azvv.a((Context)localObject, 3.0F);
          paramavow.rightMargin = i;
          paramavow.leftMargin = i;
          paramavow.topMargin = i;
          paramSquareImageView.setLayoutParams(paramavow);
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
          paramavow = URLDrawable.URLDrawableOptions.obtain();
          paramavow.mRequestWidth = paramInt3;
          paramavow.mRequestHeight = paramInt1;
          if (j == 0) {
            continue;
          }
          localObject = new GradientDrawable();
          ((GradientDrawable)localObject).setShape(0);
          ((GradientDrawable)localObject).setCornerRadius(paramInt3 / 2.0F);
          ((GradientDrawable)localObject).setColor(-1579033);
          paramavow.mLoadingDrawable = ((Drawable)localObject);
          paramavow.mFailedDrawable = ((Drawable)localObject);
          paramavow.mPlayGifImage = true;
          if (j == 0) {
            continue;
          }
          paramavow.mMemoryCacheKeySuffix = ("isAvatar" + paramInt3 + paramInt1);
          paramavow = URLDrawable.getDrawable(paramString, paramavow);
          paramavow.setDecodeHandler(azue.a);
        }
        catch (Exception paramavow)
        {
          QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + paramString, paramavow);
          localObject = localColorDrawable;
          continue;
          paramavow.mMemoryCacheKeySuffix = ("isNotAvatar" + paramInt3 + paramInt1 + paramInt2);
          paramavow = URLDrawable.getDrawable(paramString, paramavow);
          paramavow.setTag(azue.b(paramInt3, paramInt1, paramInt2));
          paramavow.setDecodeHandler(azue.i);
          continue;
        }
        localObject = paramavow;
        if (paramavow.getStatus() != 1)
        {
          localObject = paramavow;
          if (paramavow.getStatus() != 0)
          {
            paramavow.restartDownload();
            localObject = paramavow;
          }
        }
        paramSquareImageView.setImageDrawable((Drawable)localObject);
        return new Pair(Integer.valueOf(paramInt3), Integer.valueOf(paramInt1));
        paramInt1 = azvv.a((Context)localObject, 60.0F);
        i = azvv.a((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = azvv.a((Context)localObject, 50.0F);
        i = azvv.a((Context)localObject, 50.0F);
        j = 0;
        break;
        if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
        {
          paramInt1 = azvv.a(paramSquareImageView.getContext(), 50.0F);
          i = azvv.a(paramSquareImageView.getContext(), 50.0F);
          j = 1;
          break;
        }
        paramInt1 = azvv.a((Context)localObject, 60.0F);
        i = azvv.a((Context)localObject, 60.0F);
        continue;
        paramInt1 = azvv.a((Context)localObject, 50.0F);
        i = azvv.a((Context)localObject, 50.0F);
        j = 1;
        break;
        paramInt1 = azvv.a((Context)localObject, 60.0F);
        i = azvv.a((Context)localObject, 85.0F);
        j = 0;
        break;
        paramInt1 = azvv.a((Context)localObject, 113.0F);
        i = azvv.a((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = azvv.a((Context)localObject, 100.0F);
        i = azvv.a((Context)localObject, 141.0F);
        j = 0;
        break;
        paramInt1 = j;
        if ((paramavow instanceof avpm))
        {
          paramInt1 = azvv.a((Context)localObject, paramavow.jdField_a_of_type_Avox.jdField_c_of_type_Int / 2);
          i = azvv.a((Context)localObject, paramavow.jdField_a_of_type_Avox.d / 2);
        }
        if ((paramInt2 == paramavow.jdField_a_of_type_Avox.jdField_c_of_type_Int / 2) && (paramInt2 == paramavow.jdField_a_of_type_Avox.d / 2))
        {
          j = 1;
          break;
        }
        j = 0;
        break;
        paramInt1 = azvv.a((Context)localObject, 220.0F);
        i = azvv.a((Context)localObject, 136.0F);
        j = 0;
        break;
        paramInt1 = azvv.a((Context)localObject, 162.0F);
        i = azvv.a((Context)localObject, 162.0F);
        j = 0;
        break;
        paramInt1 = azvv.a((Context)localObject, 162.0F);
        i = azvv.a((Context)localObject, 228.0F);
        j = 0;
        break;
        paramInt1 = azvv.a((Context)localObject, 162.0F);
        i = azvv.a((Context)localObject, 162.0F);
        j = 1;
        break;
        paramavow.mFailedDrawable = localColorDrawable;
        paramavow.mLoadingDrawable = localColorDrawable;
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131101261));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131101261));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131101262));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131101262));
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
        paramTextView.setTextColor(localContext.getResources().getColor(2131101262));
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
      paramTextView.setTextColor(localContext.getResources().getColor(2131101395));
      return;
    }
    paramTextView.setTextSize(1, 17.0F);
    paramTextView.setTextColor(localContext.getResources().getColor(2131101267));
    paramTextView.setIncludeFontPadding(false);
  }
  
  private void a(avou paramavou, avxb paramavxb)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3 = paramavxb.a().getContext();
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
      paramavxb.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      if (!TextUtils.isEmpty(paramavou.jdField_a_of_type_JavaLangCharSequence)) {
        break label593;
      }
      paramavxb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramavou.jdField_a_of_type_Avop == null) {
        break label775;
      }
      paramavxb.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramavxb.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      i = (int)(babp.k() - vms.a((Context)localObject3, 30.0F)) / 2 - vms.a((Context)localObject3, 3.0F);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
      localObject2 = URLDrawable.getDrawable(paramavou.jdField_a_of_type_Avop.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
      paramavxb.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      localObject2 = (LinearLayout.LayoutParams)paramavxb.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = i;
      ((LinearLayout.LayoutParams)localObject2).width = i;
      paramavxb.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramavxb.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (paramavou.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      m = Math.min(paramavou.jdField_a_of_type_JavaUtilList.size(), 4);
      n = (i - vms.a((Context)localObject3, 3.0F)) / 2;
      localObject2 = new int[4];
      Object tmp295_293 = localObject2;
      tmp295_293[0] = 2131302191;
      Object tmp301_295 = tmp295_293;
      tmp301_295[1] = 2131302192;
      Object tmp307_301 = tmp301_295;
      tmp307_301[2] = 2131302193;
      Object tmp313_307 = tmp307_301;
      tmp313_307[3] = 2131302194;
      tmp313_307;
      i = 0;
      if (i >= m) {
        break label748;
      }
      localObject3 = (SquareImageView)paramavxb.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]);
      localObject4 = ((avop)paramavou.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
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
      if ((i != 3) || (paramavou.jdField_a_of_type_Int <= 4)) {
        break label731;
      }
      ((SquareImageView)localObject3).setFilterColor(Color.parseColor("#66000000"));
      k = paramavou.jdField_a_of_type_Int - 4;
      localObject4 = new StringBuilder().append("+");
      j = k;
      if (k > 99) {
        j = 99;
      }
      ((SquareImageView)localObject3).setFilterText(j);
      ((SquareImageView)localObject3).setFilterTextSize(azvv.a(paramavxb.a().getContext(), 20.0F));
    }
    for (;;)
    {
      i += 1;
      break label322;
      paramavxb.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      break;
      label593:
      i = (int)(paramavxb.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels - azvv.a(paramavxb.jdField_a_of_type_AndroidWidgetTextView.getContext(), 30.0F) - avwf.a(paramavxb.jdField_a_of_type_AndroidWidgetTextView, paramavou.jdField_a_of_type_JavaLangString));
      localObject2 = avwf.a(paramavxb.jdField_a_of_type_AndroidWidgetTextView, i, 1, paramavou.jdField_a_of_type_JavaLangCharSequence.toString(), paramavou.jdField_a_of_type_Avvu.jdField_a_of_type_JavaUtilList, false, false, true);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (paramavou.jdField_a_of_type_JavaLangString == null) {
        paramavou.jdField_a_of_type_JavaLangString = "";
      }
      paramavxb.jdField_a_of_type_AndroidWidgetTextView.setText(new SpannableStringBuilder((CharSequence)localObject1).append(paramavou.jdField_a_of_type_JavaLangString));
      paramavxb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      break label59;
      label731:
      ((SquareImageView)localObject3).setFilterColor(-1);
      ((SquareImageView)localObject3).setFilterText("");
    }
    label748:
    while (i < 4)
    {
      paramavxb.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(localObject2[i]).setVisibility(4);
      i += 1;
    }
    label775:
    paramavxb.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramavxb.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (paramavou.jdField_a_of_type_JavaUtilList != null)
    {
      m = Math.min(paramavou.jdField_a_of_type_JavaUtilList.size(), paramavxb.jdField_a_of_type_Int);
      n = (int)(babp.k() - vms.a(paramavxb.a().getContext(), (m - 1) * 2 + 27));
      i = 0;
      if (i < m)
      {
        localObject1 = (SquareImageView)paramavxb.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        localObject2 = ((avop)paramavou.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString;
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
        if (paramavou.jdField_b_of_type_Int != 0)
        {
          ((SquareImageView)localObject1).setImageScale(n / 4 * 1.0F / azvv.a((Context)localObject3, paramavou.jdField_b_of_type_Int / 2), 0.0F);
          label1007:
          ((SquareImageView)localObject1).setVisibility(0);
          if ((i != paramavxb.jdField_a_of_type_Int - 1) || (paramavou.jdField_a_of_type_Int <= paramavxb.jdField_a_of_type_Int)) {
            break label1136;
          }
          ((SquareImageView)localObject1).setFilterColor(Color.parseColor("#66000000"));
          k = paramavou.jdField_a_of_type_Int - paramavxb.jdField_a_of_type_Int;
          localObject2 = new StringBuilder().append("+");
          j = k;
          if (k > 99) {
            j = 99;
          }
          ((SquareImageView)localObject1).setFilterText(j);
          ((SquareImageView)localObject1).setFilterTextSize(azvv.a(paramavxb.a().getContext(), 20.0F));
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
      while (i < paramavxb.jdField_a_of_type_Int)
      {
        paramavxb.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setVisibility(4);
        i += 1;
      }
    }
  }
  
  private void a(avov paramavov, avxc paramavxc)
  {
    Object localObject = paramavxc.a().getContext();
    int i;
    if (!TextUtils.isEmpty(paramavov.i))
    {
      paramavxc.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a((Context)localObject, (SquareImageView)paramavxc.jdField_a_of_type_AndroidWidgetImageView, paramavxc.jdField_b_of_type_AndroidWidgetImageView, paramavxc.jdField_b_of_type_AndroidWidgetTextView, paramavov.jdField_a_of_type_Int, paramavov.i, paramavov.jdField_b_of_type_JavaLangString, ((Context)localObject).getResources().getDimensionPixelSize(2131167112));
      i = ((Context)localObject).getResources().getDimensionPixelSize(2131167112);
      if ((paramavov.jdField_a_of_type_Int == 6) || (paramavov.jdField_a_of_type_Int == 8)) {
        i = azvv.a((Context)localObject, 100.0F);
      }
      if (paramavxc.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        break label317;
      }
      i = 0;
      label127:
      float f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - azvv.a((Context)localObject, 30.0F);
      CharSequence localCharSequence = avwf.a(paramavxc.jdField_a_of_type_AndroidWidgetTextView, f, 2, paramavov.jdField_a_of_type_JavaLangCharSequence.toString(), paramavov.jdField_a_of_type_Avvu.jdField_a_of_type_JavaUtilList, false, true);
      paramavxc.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
      f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - azvv.a((Context)localObject, 30.0F) - i;
      localObject = avwf.a(paramavxc.c, f, 2, paramavov.jdField_b_of_type_JavaLangCharSequence.toString(), paramavov.jdField_a_of_type_Avvu.jdField_a_of_type_JavaUtilList, false, false);
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label333;
      }
      paramavxc.c.setTextColor(Color.parseColor("#4A4A4A"));
      paramavxc.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      a(paramavxc.c, (CharSequence)localObject, true);
      a(paramavxc.jdField_d_of_type_AndroidWidgetTextView, paramavov.jdField_c_of_type_JavaLangCharSequence);
      return;
      paramavxc.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break;
      label317:
      i += azvv.a((Context)localObject, 10.0F);
      break label127;
      label333:
      paramavxc.c.setTextColor(Color.parseColor("#737373"));
      paramavxc.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(avoy paramavoy, avxe paramavxe)
  {
    Context localContext = paramavxe.a().getContext();
    int j;
    int i;
    if (paramavoy.jdField_a_of_type_Int == 1)
    {
      j = azvv.a(localContext, 375.0F);
      i = azvv.a(localContext, 150.0F);
    }
    for (;;)
    {
      int k;
      if ((j == 0) || (i == 0))
      {
        i = azvv.a(localContext, 375.0F);
        j = azvv.a(localContext, 150.0F);
        k = i;
        i = j;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramavoy.jdField_b_of_type_JavaLangString))
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = k;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          localObject = URLDrawable.getDrawable(paramavoy.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
          paramavxe.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
            ((URLDrawable)localObject).restartDownload();
          }
          label164:
          paramavxe.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)paramavxe.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).height = ((int)(i * vms.a(localContext) * 1.0F / k));
          paramavxe.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramavxe.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
          if (TextUtils.isEmpty(paramavoy.jdField_a_of_type_JavaLangCharSequence)) {
            break label522;
          }
          paramavxe.jdField_b_of_type_AndroidWidgetTextView.setText(paramavoy.jdField_a_of_type_JavaLangCharSequence);
          paramavxe.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          label253:
          if (TextUtils.isEmpty(paramavoy.jdField_b_of_type_JavaLangCharSequence)) {
            break label534;
          }
          paramavxe.c.setText(paramavoy.jdField_b_of_type_JavaLangCharSequence);
          paramavxe.c.setVisibility(0);
          label282:
          if (TextUtils.isEmpty(paramavoy.j)) {
            break label599;
          }
          paramavxe.jdField_d_of_type_AndroidWidgetTextView.setText(paramavoy.j);
        }
        try
        {
          if (!paramavoy.k.startsWith("#")) {
            paramavoy.k = ("#" + paramavoy.k);
          }
          paramavxe.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor(paramavoy.k));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label365:
            paramavxe.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#FF00FF00"));
            if (QLog.isColorLevel()) {
              QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bigImageItem.topLeftTagColor = " + paramavoy.k);
            }
          }
        }
        paramavxe.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        Object localObject = ((ViewGroup)paramavxe.a()).getChildAt(((ViewGroup)paramavxe.a()).getChildCount() - 1);
        if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof LinearLayout.LayoutParams)))
        {
          if (paramavoy.b() != 0) {
            break label611;
          }
          ((LinearLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = 0;
          paramavxe.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, azvv.a(localContext, 6.0F));
        }
        label522:
        label534:
        label599:
        label611:
        while (paramavoy.b() != 2)
        {
          return;
          if (paramavoy.jdField_a_of_type_Int == 2)
          {
            j = azvv.a(localContext, 375.0F);
            i = azvv.a(localContext, 180.0F);
            break;
          }
          if (paramavoy.jdField_a_of_type_Int != 0) {
            break label639;
          }
          j = azvv.a(localContext, paramavoy.jdField_a_of_type_Float / 2.0F);
          i = azvv.a(localContext, paramavoy.jdField_b_of_type_Float / 2.0F);
          break;
          paramavxe.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label164;
          paramavxe.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label253;
          paramavxe.c.setVisibility(8);
          break label282;
          paramavxe.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
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
  
  private void a(avpa paramavpa, avxg paramavxg)
  {
    Object localObject1 = paramavxg.a().getContext();
    Object localObject2 = paramavxg.a();
    if (paramavpa.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), vms.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), vms.a(((View)localObject2).getContext(), 6.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131305951);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131302252);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), vms.a(((View)localObject2).getContext(), 3.0F), ((View)localObject2).getPaddingRight(), vms.a(((View)localObject2).getContext(), 3.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (paramavpa.jdField_c_of_type_Boolean)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(vms.a((Context)localObject1, 4.0F));
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
    if (!TextUtils.isEmpty(paramavpa.i)) {
      a((Context)localObject1, (SquareImageView)paramavxg.b(), paramavxg.jdField_b_of_type_AndroidWidgetImageView, paramavxg.jdField_a_of_type_AndroidWidgetTextView, paramavpa.jdField_a_of_type_Int, paramavpa.i, null, azvv.a((Context)localObject1, 32.0F));
    }
    label687:
    Object localObject5;
    if (!TextUtils.isEmpty(paramavpa.jdField_a_of_type_JavaLangString))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramavxg.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramavxg.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramavpa.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramavxg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramavxg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131167112);
      if ((paramavpa.jdField_a_of_type_Int == 6) || (paramavpa.jdField_a_of_type_Int == 8)) {
        i = azvv.a((Context)localObject1, 100.0F);
      }
      localObject2 = avwf.a(paramavxg.a(), 10.0F * avwf.a(paramavxg.a(), ajjy.a(2131647874)), 1, paramavpa.jdField_a_of_type_JavaLangCharSequence.toString(), paramavpa.jdField_a_of_type_Avvu.jdField_a_of_type_JavaUtilList, false, false, true);
      paramavxg.a().setText((CharSequence)localObject2);
      paramavxg.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - azvv.a((Context)localObject1, 40.0F) - i;
      localObject2 = avwf.a(paramavxg.b(), f1, 2, paramavpa.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(paramavxg.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(paramavpa.jdField_c_of_type_JavaLangCharSequence)) {
        break label1047;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - azvv.a((Context)localObject1, 30.0F);
      localObject2 = avwf.a(paramavxg.c(), f1, 2, paramavpa.jdField_c_of_type_JavaLangCharSequence.toString(), paramavpa.jdField_a_of_type_Avvu.jdField_a_of_type_JavaUtilList, false, false);
      paramavxg.c().setText((CharSequence)localObject2);
      paramavxg.c().setVisibility(0);
      if (paramavpa.jdField_a_of_type_JavaUtilList == null) {
        break label1479;
      }
      if (paramavpa.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1071;
      }
      paramavxg.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      paramavxg.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject3 = paramavxg.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject3).getDisplayMetrics().widthPixels;
      }
      localObject2 = paramavxg.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramavpa.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject3).getDimension(2131167105);
      float f2 = ((Resources)localObject3).getDimension(2131167105);
      i = azvv.a(paramavxg.a().getContext(), 2.0F);
      j = paramavxg.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * paramavpa.jdField_b_of_type_Double);
      j = (int)(j * paramavpa.jdField_b_of_type_Double);
      ((SquareImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      localObject3 = (avop)paramavpa.jdField_a_of_type_JavaUtilList.get(0);
      localObject4 = ((avop)localObject3).jdField_a_of_type_JavaLangString;
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
      if (((avop)localObject3).jdField_a_of_type_Int != 2) {
        break label1059;
      }
      paramavxg.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if ((paramavpa.jdField_c_of_type_JavaUtilList != null) || (!TextUtils.equals(paramavpa.k, "0")) || (!TextUtils.equals(paramavpa.m, "0"))) {
        break label1500;
      }
      paramavxg.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
      paramavxg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1047:
      paramavxg.c().setVisibility(8);
      break label687;
      label1059:
      paramavxg.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      label1071:
      paramavxg.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramavxg.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = paramavxg.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < paramavpa.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = paramavxg.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131302252);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131303222);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramavpa.jdField_a_of_type_Double), 0.0F);
          localObject4 = (avop)paramavpa.jdField_a_of_type_JavaUtilList.get(i);
          localObject5 = ((avop)localObject4).jdField_a_of_type_JavaLangString;
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
          if (((avop)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1312:
            if ((i != m - 1) || (paramavpa.jdField_b_of_type_Int <= m)) {
              break label1433;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            int k = paramavpa.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(azvv.a(((SquareImageView)localObject2).getContext(), 20.0F));
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
        paramavxg.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
      continue;
      label1479:
      paramavxg.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramavxg.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    label1500:
    if (paramavpa.jdField_c_of_type_JavaUtilList != null)
    {
      paramavxg.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      i = paramavpa.jdField_c_of_type_JavaUtilList.size() - 1;
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
    for (int j = azvv.a((Context)localObject1, 11.0F) * i;; j = 0)
    {
      localObject2 = (SquareImageView)LayoutInflater.from((Context)localObject1).inflate(2131494054, null, false);
      localObject3 = new RelativeLayout.LayoutParams(azvv.a((Context)localObject1, 16.0F), azvv.a((Context)localObject1, 16.0F));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = j;
      paramavxg.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, paramavpa.jdField_c_of_type_JavaUtilList.size() - 1 - i, (ViewGroup.LayoutParams)localObject3);
      localObject3 = (String)paramavpa.jdField_c_of_type_JavaUtilList.get(i);
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((SquareImageView)localObject2).getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = ((SquareImageView)localObject2).getLayoutParams().height;
      localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
      ((URLDrawable)localObject3).setDecodeHandler(azue.a);
      ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject3);
      if ((((URLDrawable)localObject3).getStatus() != 1) && (((URLDrawable)localObject3).getStatus() != 0)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      ((SquareImageView)localObject2).setVisibility(0);
      i -= 1;
      break;
      paramavxg.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      label1758:
      if (!TextUtils.isEmpty(paramavpa.jdField_b_of_type_JavaLangString))
      {
        paramavxg.jdField_b_of_type_AndroidWidgetTextView.setText(paramavpa.jdField_b_of_type_JavaLangString);
        paramavxg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (TextUtils.isEmpty(paramavpa.j)) {
          break label2084;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramavxg.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramavxg.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(paramavpa.j, (URLDrawable.URLDrawableOptions)localObject1);
        paramavxg.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        paramavxg.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        label1900:
        if (TextUtils.isEmpty(paramavpa.k)) {
          break label2096;
        }
        paramavxg.c.setText(paramavpa.k);
        paramavxg.c.setVisibility(0);
        if (TextUtils.isEmpty(paramavpa.l)) {
          break label2108;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramavxg.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramavxg.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(paramavpa.l, (URLDrawable.URLDrawableOptions)localObject1);
        paramavxg.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        paramavxg.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramavpa.m)) {
          break label2120;
        }
        paramavxg.jdField_d_of_type_AndroidWidgetTextView.setText(paramavpa.m);
        paramavxg.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        paramavxg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
        paramavxg.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        break label1900;
        paramavxg.c.setVisibility(8);
        break label1929;
        paramavxg.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      paramavxg.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
  }
  
  private void a(avpg paramavpg, avxm paramavxm)
  {
    Object localObject = paramavxm.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(paramavpg.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = azvv.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = azvv.a(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramavpg.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramavxm.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramavxm.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(paramavpg.j)) {
        break label504;
      }
      paramavxm.jdField_a_of_type_AndroidWidgetTextView.setText(paramavpg.j);
      paramavxm.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(paramavpg.g)) {
        break label516;
      }
      paramavxm.jdField_b_of_type_AndroidWidgetTextView.setText(paramavpg.g);
      paramavxm.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(paramavpg.k)) {
        break label528;
      }
      paramavxm.c.setVisibility(0);
      paramavxm.c.setText(paramavpg.k);
      label262:
      if (TextUtils.isEmpty(paramavpg.l)) {
        break label540;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = azvv.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = azvv.a(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "rightIcon";
      localObject = URLDrawable.getDrawable(paramavpg.l, (URLDrawable.URLDrawableOptions)localObject);
      paramavxm.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramavxm.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      label377:
      paramavxm.a(paramavpg);
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label552;
      }
      paramavxm.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839096);
      paramavxm.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839096);
      paramavxm.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      paramavxm.c.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      if (paramavxm.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramavxm.jdField_b_of_type_AndroidWidgetTextView.setTextColor(avwf.b());
      }
      paramavxm.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new avsl(this, paramavpg, localContext));
      paramavxm.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(new avsm(this, paramavpg, localContext));
      return;
      paramavxm.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label504:
      paramavxm.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label516:
      paramavxm.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label233;
      label528:
      paramavxm.c.setVisibility(8);
      break label262;
      label540:
      paramavxm.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label377;
      label552:
      paramavxm.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839095);
      paramavxm.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839095);
      paramavxm.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
      paramavxm.c.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(avph paramavph, avxo paramavxo)
  {
    Object localObject = paramavxo.a();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(paramavph.jdField_b_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = azvv.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = azvv.a(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramavph.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramavxo.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramavxo.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (TextUtils.isEmpty(paramavph.j)) {
        break label363;
      }
      paramavxo.jdField_a_of_type_AndroidWidgetTextView.setText(paramavph.j);
      paramavxo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(paramavph.g)) {
        break label375;
      }
      paramavxo.c.setText(paramavph.g);
      paramavxo.c.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(paramavph.k)) {
        break label387;
      }
      paramavxo.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      paramavxo.jdField_d_of_type_AndroidWidgetTextView.setText(paramavph.k);
      label262:
      if (!paramavph.jdField_b_of_type_Boolean) {
        break label399;
      }
      paramavxo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      avsv.a(null, 0, paramavph.jdField_c_of_type_Int, "0X8009D5C", 0, 0, null, null);
      if ((paramavph.jdField_a_of_type_JavaUtilList != null) && (paramavph.jdField_a_of_type_JavaUtilList.size() > 0)) {
        avsv.a(null, 0, paramavph.jdField_c_of_type_Int, "0X8009D5E", 0, 0, null, null);
      }
      paramavxo.a(paramavph);
      paramavxo.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new avsk(this, paramavph, localContext));
      return;
      paramavxo.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label363:
      paramavxo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label204;
      label375:
      paramavxo.c.setVisibility(8);
      break label233;
      label387:
      paramavxo.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      break label262;
      label399:
      paramavxo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void a(avpj paramavpj, avxu paramavxu)
  {
    if ((paramavpj == null) || (paramavxu == null)) {
      return;
    }
    paramavxu.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(paramavxu.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft(), 0, paramavxu.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight(), 0);
    Object localObject = (RelativeLayout.LayoutParams)paramavxu.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (paramavpj.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localObject = paramavxu.jdField_a_of_type_AndroidWidgetTextView.getContext();
      int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - azvv.a((Context)localObject, 38.0F);
      if (TextUtils.isEmpty(paramavpj.jdField_b_of_type_JavaLangCharSequence)) {
        break label310;
      }
      paramavxu.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!bool) {
        break label296;
      }
      paramavxu.jdField_b_of_type_AndroidWidgetTextView.setText(paramavpj.jdField_b_of_type_JavaLangCharSequence.toString());
      label148:
      float f1 = i;
      float f2 = avwf.a(paramavxu.jdField_b_of_type_AndroidWidgetTextView, paramavpj.jdField_b_of_type_JavaLangCharSequence);
      i = (int)(f1 - (azvv.a((Context)localObject, 10.0F) + f2));
      label182:
      if (TextUtils.isEmpty(paramavpj.jdField_a_of_type_JavaLangCharSequence)) {
        break label334;
      }
      paramavxu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = paramavpj.jdField_a_of_type_JavaLangCharSequence;
      if (paramavpj.jdField_b_of_type_Boolean) {
        break label346;
      }
      localObject = avwf.a(paramavxu.jdField_a_of_type_AndroidWidgetTextView, i, (CharSequence)localObject);
    }
    label296:
    label310:
    label334:
    label346:
    for (;;)
    {
      if (bool) {
        paramavxu.jdField_a_of_type_AndroidWidgetTextView.setText(((CharSequence)localObject).toString());
      }
      for (;;)
      {
        paramavxu.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(a(paramavpj.jdField_a_of_type_JavaLangString));
        paramavxu.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new avsn(this, paramavpj, paramavxu));
        return;
        ((RelativeLayout.LayoutParams)localObject).addRule(14, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(5);
        break;
        paramavxu.jdField_b_of_type_AndroidWidgetTextView.setText(paramavpj.jdField_b_of_type_JavaLangCharSequence);
        break label148;
        paramavxu.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label182;
        paramavxu.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        continue;
        paramavxu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  private void a(avpk paramavpk, avxt paramavxt)
  {
    if ((paramavpk == null) || (paramavxt == null)) {}
    while ((TextUtils.isEmpty(paramavpk.jdField_a_of_type_JavaLangString)) || (paramavxt.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    Context localContext = paramavxt.jdField_a_of_type_AndroidWidgetTextView.getContext();
    int j = localContext.getResources().getDisplayMetrics().widthPixels - azvv.a(localContext, 40.0F);
    int i;
    if ((!TextUtils.isEmpty(paramavpk.e)) && (paramavxt.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      paramavxt.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      i = j - azvv.a(localContext, 26.0F);
    }
    for (;;)
    {
      paramavpk = avwf.a(paramavxt.jdField_a_of_type_AndroidWidgetTextView, i, paramavpk.jdField_a_of_type_JavaLangString);
      paramavxt.jdField_a_of_type_AndroidWidgetTextView.setText(paramavpk);
      return;
      i = j;
      if (paramavxt.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        paramavxt.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        i = j;
      }
    }
  }
  
  private void a(avpm paramavpm, avxw paramavxw)
  {
    Context localContext = paramavxw.jdField_b_of_type_AndroidWidgetRelativeLayout.getContext();
    Object localObject = (RelativeLayout.LayoutParams)paramavxw.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramavxw.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (paramavpm.jdField_b_of_type_Boolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(10, 0);
    }
    for (;;)
    {
      localObject = a(paramavpm, paramavxw, false, 0);
      if (((Integer)((Pair)localObject).first).intValue() != 0) {
        ((RelativeLayout.LayoutParams)paramavxw.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).rightMargin = azvv.a(localContext, 10.0F);
      }
      int i = a(paramavpm, paramavxw);
      int j = a(paramavpm, paramavxw, ((Integer)((Pair)localObject).first).intValue(), i);
      i = j;
      if (((Integer)((Pair)localObject).second).intValue() > j) {
        i = ((Integer)((Pair)localObject).second).intValue();
      }
      if (paramavxw.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        ((RelativeLayout.LayoutParams)paramavxw.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = i;
      }
      return;
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      localLayoutParams.addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
      localLayoutParams.addRule(15, 0);
    }
  }
  
  private void a(avpq paramavpq, avxx paramavxx)
  {
    Object localObject1 = paramavxx.a().getContext();
    Object localObject2 = paramavxx.a();
    if (paramavpq.jdField_b_of_type_Boolean) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), vms.a(((View)localObject2).getContext(), 9.0F), ((View)localObject2).getPaddingRight(), vms.a(((View)localObject2).getContext(), 9.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131305951);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131302252);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), vms.a(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), vms.a(((View)localObject2).getContext(), 6.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (paramavpq.jdField_c_of_type_Boolean)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(vms.a((Context)localObject1, 4.0F));
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
      paramavxx.a().setTextColor(Color.parseColor("#6991B8"));
      paramavxx.c().setTextColor(Color.parseColor("#44608A"));
      paramavxx.b().setTextColor(Color.parseColor("#44608A"));
      if (!TextUtils.isEmpty(paramavpq.i)) {
        a((Context)localObject1, (SquareImageView)paramavxx.b(), paramavxx.jdField_b_of_type_AndroidWidgetImageView, paramavxx.jdField_a_of_type_AndroidWidgetTextView, paramavpq.jdField_a_of_type_Int, paramavpq.i, null, azvv.a((Context)localObject1, 21.0F));
      }
      if (TextUtils.isEmpty(paramavpq.jdField_a_of_type_JavaLangString)) {
        break label1085;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramavxx.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramavxx.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramavpq.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramavxx.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramavxx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131167112);
      if ((paramavpq.jdField_a_of_type_Int == 6) || (paramavpq.jdField_a_of_type_Int == 8)) {
        i = azvv.a((Context)localObject1, 100.0F);
      }
      localObject2 = avwf.a(paramavxx.a(), 10.0F * avwf.a(paramavxx.a(), ajjy.a(2131647873)), 1, paramavpq.jdField_a_of_type_JavaLangCharSequence.toString(), paramavpq.jdField_a_of_type_Avvu.jdField_a_of_type_JavaUtilList, false, false, true);
      paramavxx.a().setText((CharSequence)localObject2);
      paramavxx.a().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - azvv.a((Context)localObject1, 40.0F) - i;
      localObject2 = avwf.a(paramavxx.b(), f1, 2, paramavpq.jdField_b_of_type_JavaLangCharSequence.toString(), "", false, false, true);
      a(paramavxx.b(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(paramavpq.jdField_c_of_type_JavaLangCharSequence)) {
        break label1097;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - azvv.a((Context)localObject1, 30.0F);
      localObject2 = avwf.a(paramavxx.c(), f1, 2, paramavpq.jdField_c_of_type_JavaLangCharSequence.toString(), paramavpq.jdField_a_of_type_Avvu.jdField_a_of_type_JavaUtilList, false, false);
      paramavxx.c().setText((CharSequence)localObject2);
      paramavxx.c().setVisibility(0);
      label740:
      if (paramavpq.jdField_a_of_type_JavaUtilList == null) {
        break label1546;
      }
      if (paramavpq.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label1119;
      }
      paramavxx.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      paramavxx.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject2 = paramavxx.a().getResources();
      if (jdField_a_of_type_Int == 0) {
        jdField_a_of_type_Int = ((Resources)localObject2).getDisplayMetrics().widthPixels;
      }
      localObject1 = paramavxx.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
      ((SquareImageView)localObject1).setImageScale((float)(1.0D / paramavpq.jdField_a_of_type_Double), 0.0F);
      f1 = ((Resources)localObject2).getDimension(2131167105);
      float f2 = ((Resources)localObject2).getDimension(2131167105);
      i = azvv.a(paramavxx.a().getContext(), 2.0F);
      j = paramavxx.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      j = (int)(jdField_a_of_type_Int - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * paramavpq.jdField_b_of_type_Double);
      j = (int)(j * paramavpq.jdField_b_of_type_Double);
      ((SquareImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      paramavpq = (avop)paramavpq.jdField_a_of_type_JavaUtilList.get(0);
      localObject2 = paramavpq.jdField_a_of_type_JavaLangString;
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
      if (paramavpq.jdField_a_of_type_Int != 2) {
        break label1109;
      }
      paramavxx.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      return;
      paramavxx.a().setTextColor(Color.parseColor("#262626"));
      paramavxx.c().setTextColor(Color.parseColor("#737373"));
      paramavxx.b().setTextColor(Color.parseColor("#737373"));
      break;
      label1085:
      paramavxx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label496;
      label1097:
      paramavxx.c().setVisibility(8);
      break label740;
      label1109:
      paramavxx.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      label1119:
      paramavxx.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      paramavxx.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      int m = paramavxx.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      j = i;
      if (i < paramavpq.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = paramavxx.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131302252);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131303222);
          j = vms.a((Context)localObject1) / m;
          int k = (int)(j * paramavpq.jdField_a_of_type_Double);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramavpq.jdField_a_of_type_Double), 0.0F);
          localObject4 = (avop)paramavpq.jdField_a_of_type_JavaUtilList.get(i);
          Object localObject5 = ((avop)localObject4).jdField_a_of_type_JavaLangString;
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
          if (((avop)localObject4).jdField_a_of_type_Int == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1379:
            if ((i != m - 1) || (paramavpq.jdField_b_of_type_Int <= m)) {
              break label1500;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            k = paramavpq.jdField_b_of_type_Int - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(azvv.a(((SquareImageView)localObject2).getContext(), 20.0F));
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
        paramavxx.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
        j += 1;
      }
    }
    label1546:
    paramavxx.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    paramavxx.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void a(SquareImageView paramSquareImageView, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    paramSquareImageView.getLayoutParams().width = azvv.a(paramSquareImageView.getContext(), paramInt1);
    paramSquareImageView.getLayoutParams().height = azvv.a(paramSquareImageView.getContext(), paramInt2);
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
  
  private void b(avpm paramavpm, avxw paramavxw)
  {
    if ((paramavpm == null) || (paramavpm.jdField_a_of_type_Avpn == null) || (paramavxw == null)) {
      if ((paramavxw != null) && (paramavxw.jdField_b_of_type_AndroidWidgetButton != null)) {
        paramavxw.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
    while (paramavxw.jdField_b_of_type_AndroidWidgetButton == null) {
      return;
    }
    Context localContext = paramavxw.jdField_b_of_type_AndroidWidgetButton.getContext();
    if ((paramavpm.jdField_a_of_type_Avpn.jdField_a_of_type_Int == 1) && (!TextUtils.isEmpty(paramavpm.jdField_a_of_type_Avpn.jdField_a_of_type_JavaLangCharSequence)))
    {
      paramavxw.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      paramavxw.jdField_b_of_type_AndroidWidgetButton.setText(paramavpm.jdField_a_of_type_Avpn.jdField_a_of_type_JavaLangCharSequence);
      paramavxw.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new avsq(this, localContext, paramavpm));
      return;
    }
    paramavxw.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
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
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130841716, false);
      return;
    case 4: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130841716, false);
      return;
    case 5: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, true);
      return;
    case 6: 
      paramInt1 = azvv.a(paramContext, 62.0F);
      a(paramSquareImageView, paramImageView, paramTextView, azvv.a(paramContext, 100.0F), paramInt1, false, paramString1, null, 2130841716, false);
      return;
    case 7: 
      a(paramSquareImageView, paramImageView, paramTextView, azvv.a(paramContext, 100.0F), azvv.a(paramContext, 62.0F), false, paramString1, paramString2, 0, false);
      return;
    }
    a(paramSquareImageView, paramImageView, paramTextView, azvv.a(paramContext, 100.0F), azvv.a(paramContext, 62.0F), false, paramString1, null, 0, false);
  }
  
  public void a(ImageView paramImageView)
  {
    if (paramImageView == null) {}
    Animation localAnimation;
    do
    {
      return;
      localAnimation = AnimationUtils.loadAnimation(paramImageView.getContext(), 2130772182);
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
  
  public void a(avow paramavow, avxd paramavxd)
  {
    avwi.a(paramavow.a(), paramavow.b(), paramavxd.a(), paramavow.jdField_a_of_type_Boolean, paramavow.r, paramavow.f);
    switch (paramavow.d())
    {
    }
    for (;;)
    {
      b(paramavow, paramavxd);
      if (TextUtils.isEmpty(paramavow.i)) {
        c(paramavow, paramavxd);
      }
      return;
      a((avou)paramavow, (avxb)paramavxd);
      continue;
      a((avpq)paramavow, (avxx)paramavxd);
      continue;
      a((avov)paramavow, (avxc)paramavxd);
      continue;
      a((avpd)paramavow, (avxj)paramavxd);
      continue;
      a((avpm)paramavow, (avxw)paramavxd);
      continue;
      a((avpj)paramavow, (avxu)paramavxd);
      continue;
      a((avpk)paramavow, (avxt)paramavxd);
      continue;
      a((avpa)paramavow, (avxg)paramavxd);
      continue;
      a((avoy)paramavow, (avxe)paramavxd);
      continue;
      a((avpb)paramavow, (avxh)paramavxd);
      continue;
      a((avpl)paramavow, (avxv)paramavxd);
      continue;
      a((avpi)paramavow, (avxr)paramavxd);
      continue;
      a((avpg)paramavow, (avxm)paramavxd);
      continue;
      a((avph)paramavow, (avxo)paramavxd);
      continue;
      a((avpf)paramavow, (avxl)paramavxd);
    }
  }
  
  public void a(avow paramavow, avxd paramavxd, Bitmap paramBitmap)
  {
    if (paramavxd.b() != null) {
      paramavxd.b().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(avpb paramavpb, avxh paramavxh)
  {
    if ((paramavpb.jdField_a_of_type_JavaUtilArrayList == null) || (paramavpb.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorSlidingContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
      return;
    }
    avkn localavkn2 = (avkn)paramavxh.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter();
    avkn localavkn1;
    if (localavkn2 != null)
    {
      localavkn1 = localavkn2;
      if (localavkn2.a() == paramavpb.jdField_a_of_type_JavaUtilArrayList) {}
    }
    else
    {
      localavkn1 = new avkn(paramavpb, this.jdField_a_of_type_Avkm.jdField_b_of_type_Int, paramavxh.jdField_a_of_type_ComTencentWidgetHorizontalListView);
      paramavxh.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(localavkn1);
    }
    if (localavkn1.a() != paramavpb.jdField_a_of_type_JavaUtilArrayList)
    {
      paramavxh.jdField_a_of_type_Avpb = paramavpb;
      paramavxh.jdField_a_of_type_ComTencentWidgetHorizontalListView.resetCurrentX(paramavpb.jdField_b_of_type_Int);
    }
    localavkn1.a(paramavpb.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(avpd paramavpd, avxj paramavxj)
  {
    paramavxj.a().getContext();
    paramavxj.a();
    if ((paramavpd.jdField_a_of_type_JavaUtilArrayList == null) || (paramavpd.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
    }
    for (;;)
    {
      return;
      paramavxj.a(paramavpd);
      if (paramavpd.jdField_a_of_type_JavaUtilArrayList.size() != paramavxj.jdField_a_of_type_JavaUtilArrayList.size()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, view.size != model.size");
      }
      int j = paramavpd.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((avpc)paramavpd.jdField_a_of_type_JavaUtilArrayList.get(i)).a((avxi)paramavxj.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
    }
  }
  
  protected void a(avpf paramavpf, avxl paramavxl)
  {
    Object localObject2 = (LinearLayout)paramavxl.b();
    Object localObject1;
    Object localObject3;
    avwz localavwz;
    if ((localObject2 != null) && (paramavpf.a != null))
    {
      ((LinearLayout)localObject2).removeAllViews();
      if (((LinearLayout)localObject2).getParent() != null) {
        ((View)((LinearLayout)localObject2).getParent()).setPadding(0, 0, 0, 0);
      }
      localObject1 = paramavpf.a;
      paramavpf = paramavxl.a().getContext();
      localObject3 = LayoutInflater.from(paramavpf).inflate(2131496790, null);
      localavwz = new avwz((View)localObject3);
      Object localObject4 = ((View)localObject3).findViewById(2131302703);
      int i = bajq.a(6.0F);
      ((View)localObject4).setPadding(0, i, 0, i);
      ((LinearLayout)localObject2).addView((View)localObject3);
      if (((avos)localObject1).c() != null) {
        break label559;
      }
      if (localavwz.c() != null) {
        localavwz.c().setVisibility(8);
      }
      if (localavwz.a() != null) {
        localavwz.a().setVisibility(8);
      }
      localObject2 = localavwz.a();
      if (localObject2 != null) {
        ((URLImageView)localObject2).setVisibility(8);
      }
      localObject2 = localavwz.e();
      if (localObject2 != null)
      {
        ((TextView)localObject2).setVisibility(0);
        if (!TextUtils.isEmpty(((avos)localObject1).a())) {
          ((TextView)localObject2).setText(((avos)localObject1).a());
        }
      }
      if ((localavwz.b() != null) && (!TextUtils.isEmpty(((avos)localObject1).g())))
      {
        localObject2 = ((avos)localObject1).g();
        localObject3 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = azvv.a(paramavpf, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = azvv.a(paramavpf, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
        if (!befm.a((String)localObject2)) {
          break label684;
        }
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
        ((URLDrawable)localObject2).setTag(azue.b(azvv.a(paramavpf, 50.0F), azvv.a(paramavxl.a().getContext(), 50.0F), azvv.a(paramavpf, 3.0F)));
        ((URLDrawable)localObject2).setDecodeHandler(azue.i);
        localavwz.b().setImageDrawable((Drawable)localObject2);
        if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
          ((URLDrawable)localObject2).restartDownload();
        }
      }
    }
    for (;;)
    {
      localavwz.a().setOnClickListener(new avsj(this, (avos)localObject1));
      if ((localavwz.a() != null) && (((avos)localObject1).c()))
      {
        paramavxl = ((avos)localObject1).h();
        localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = azvv.a(paramavpf, 40.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = azvv.a(paramavpf, 12.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        paramavxl = URLDrawable.getDrawable(paramavxl, (URLDrawable.URLDrawableOptions)localObject2);
        paramavxl.setTag(azue.b(azvv.a(paramavpf, 38.0F), azvv.a(paramavpf, 12.0F), 0));
        paramavxl.setDecodeHandler(azue.i);
        localavwz.a().setImageDrawable(paramavxl);
        if ((paramavxl.getStatus() != 1) && (paramavxl.getStatus() != 0)) {
          paramavxl.restartDownload();
        }
      }
      return;
      label559:
      if ((localavwz.c() != null) && (!TextUtils.isEmpty(((avos)localObject1).c())))
      {
        localavwz.c().setVisibility(0);
        localavwz.c().setText(((avos)localObject1).c());
      }
      for (;;)
      {
        if (localavwz.a() != null) {
          localavwz.a().setVisibility(0);
        }
        localObject2 = localavwz.e();
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(8);
        }
        if (TextUtils.isEmpty(((avos)localObject1).a())) {
          break;
        }
        localavwz.a().setText(((avos)localObject1).a());
        break;
        if (localavwz.c() != null) {
          localavwz.c().setVisibility(8);
        }
      }
      label684:
      localavwz.b().setImageDrawable((Drawable)localObject3);
    }
  }
  
  protected void a(avpi paramavpi, avxr paramavxr)
  {
    Object localObject1 = paramavxr.a().getContext();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramavxr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      paramavxr.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#4A4A4A"));
      if (TextUtils.isEmpty(paramavpi.jdField_b_of_type_JavaLangString)) {
        break label290;
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = azvv.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = azvv.a((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "askIcon";
      localObject2 = URLDrawable.getDrawable(paramavpi.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
      paramavxr.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramavxr.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    label290:
    for (;;)
    {
      label166:
      if (!TextUtils.isEmpty(paramavpi.j))
      {
        int j = paramavxr.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
        int i = (int)avwf.a(paramavxr.jdField_a_of_type_AndroidWidgetTextView, " ");
        int k = azvv.a((Context)localObject1, 22.0F) / i;
        localObject1 = "";
        i = 0;
        for (;;)
        {
          if (i < k)
          {
            localObject1 = (String)localObject1 + " ";
            i += 1;
            continue;
            paramavxr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
            paramavxr.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
            break;
            paramavxr.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            break label166;
          }
        }
        localObject1 = avwf.a(paramavxr.jdField_a_of_type_AndroidWidgetTextView, j, 2, (String)localObject1 + paramavpi.j, paramavpi.jdField_a_of_type_Avvu.jdField_a_of_type_JavaUtilList, false, false, true);
        paramavxr.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      }
    }
    paramavxr.a(paramavpi);
    if ((!TextUtils.isEmpty(paramavpi.k)) && (paramavpi.jdField_a_of_type_JavaUtilList != null) && (paramavpi.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      paramavxr.jdField_b_of_type_AndroidWidgetTextView.setText(paramavpi.k);
      paramavxr.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    paramavxr.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void a(avpl paramavpl, avxv paramavxv)
  {
    if (!TextUtils.isEmpty(paramavpl.jdField_b_of_type_JavaLangString))
    {
      paramavxv.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramavxv.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramavxv.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height;
      localObject = URLDrawable.getDrawable(paramavpl.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      paramavxv.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      if (TextUtils.isEmpty(paramavpl.j)) {
        break label345;
      }
      paramavxv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      int i = paramavxv.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getDisplayMetrics().widthPixels;
      localObject = avwf.a(paramavxv.jdField_a_of_type_AndroidWidgetTextView, i, 1, paramavpl.j, paramavpl.jdField_a_of_type_Avvu.jdField_a_of_type_JavaUtilList, false, false, true);
      paramavxv.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      label183:
      if (TextUtils.isEmpty(paramavpl.l)) {
        break label357;
      }
      paramavxv.jdField_b_of_type_AndroidWidgetTextView.setText(paramavpl.l);
      paramavxv.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramavxv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label220:
      if (TextUtils.isEmpty(paramavpl.k)) {
        break label378;
      }
      paramavxv.c.setText(paramavpl.k);
      paramavxv.c.setVisibility(0);
    }
    for (;;)
    {
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label390;
      }
      paramavxv.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramavxv.jdField_a_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131101198));
      paramavxv.c.setTextColor(paramavxv.c.getContext().getResources().getColor(2131101197));
      paramavxv.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramavxv.jdField_b_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131101197));
      return;
      paramavxv.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break;
      label345:
      paramavxv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label183;
      label357:
      paramavxv.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramavxv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label220;
      label378:
      paramavxv.c.setVisibility(8);
    }
    label390:
    paramavxv.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#262626"));
    paramavxv.c.setTextColor(Color.parseColor("#737373"));
    paramavxv.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
  }
  
  public void a(SquareImageView paramSquareImageView, ImageView paramImageView, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, int paramInt3, boolean paramBoolean2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramSquareImageView.getLayoutParams();
    if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
    {
      localLayoutParams.width = azvv.a(paramSquareImageView.getContext(), 50.0F);
      localLayoutParams.height = azvv.a(paramSquareImageView.getContext(), 50.0F);
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
          paramTextView.setDecodeHandler(azue.a);
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
  
  protected void b(avow paramavow, avxd paramavxd)
  {
    if (paramavxd.a() != null) {
      paramavxd.a().setOnClickListener(new avsi(this, paramavow));
    }
  }
  
  public void c(avow paramavow, avxd paramavxd)
  {
    if ((paramavxd.b() != null) && ((paramavow instanceof avok)) && (!TextUtils.isEmpty(paramavow.b()))) {
      paramavxd.b().setImageDrawable(avwf.a(this.jdField_a_of_type_Azwg, paramavow));
    }
  }
  
  public String getToken()
  {
    return QQPlayerService.a(7, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c());
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
      avwf.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localImageView.post(new SearchTemplatePresenter.11(this, localImageView, bool));
      localImageView.setContentDescription(localResources.getString(2131624714));
      this.jdField_a_of_type_Avkm.notifyDataSetChanged();
      return;
    }
    localImageView.post(new SearchTemplatePresenter.12(this, localImageView, bool));
    localImageView.setContentDescription(localResources.getString(2131624712));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsh
 * JD-Core Version:    0.7.0.1
 */