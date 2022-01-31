import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.minigame.utils.DpUtil;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class apvv
{
  public static int a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return 106;
    }
    return DpUtil.dip2px(paramQQAppInterface.getApp(), 53.0F);
  }
  
  private static int a(String paramString)
  {
    return Integer.decode(paramString).intValue() | 0xFF000000;
  }
  
  public static List<anbr> a()
  {
    return (List)anbs.a().a().get("wording");
  }
  
  private static List<anbr> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = apvb.a(paramString).toLowerCase().replace(".", "");
    return (List)anbs.a().a().get(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, View paramView, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, apvy paramapvy)
  {
    if ((paramTeamWorkFileImportInfo == null) || (paramActivity == null)) {}
    do
    {
      return;
      paramActivity = paramActivity.getResources();
    } while (paramActivity == null);
    Object localObject = a(paramTeamWorkFileImportInfo.b);
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (paramTeamWorkFileImportInfo.a != 1)
      {
        paramTeamWorkFileImportInfo = ((List)localObject).iterator();
        while (paramTeamWorkFileImportInfo.hasNext())
        {
          localObject = (anbr)paramTeamWorkFileImportInfo.next();
          if (((anbr)localObject).b() != 2) {
            localArrayList.add(localObject);
          }
        }
      }
      localArrayList.addAll((Collection)localObject);
    }
    a(paramQQAppInterface, paramActivity, paramView, localArrayList, paramapvy);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Resources paramResources, View paramView, List<anbr> paramList, apvy paramapvy)
  {
    if ((paramView == null) || (paramapvy == null) || (paramList == null) || (paramList.size() == 0)) {}
    ViewGroup localViewGroup;
    do
    {
      return;
      paramResources = (ViewGroup)paramView.findViewById(2131366381);
      localViewGroup = (ViewGroup)paramView.findViewById(2131363352);
    } while ((paramResources == null) || (localViewGroup == null));
    paramView.setVisibility(8);
    paramResources.setVisibility(8);
    localViewGroup.setVisibility(8);
    LayoutInflater localLayoutInflater = (LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      anbr localanbr = (anbr)paramList.next();
      View localView;
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      switch (localanbr.a())
      {
      default: 
        QLog.w("TencentDocConvertABTestUtil", 2, "can not show edit entrance");
        break;
      case 1: 
        paramView.setVisibility(0);
        paramResources.setVisibility(0);
        localView = localLayoutInflater.inflate(2131560492, paramResources, false);
        Object localObject1 = (GradientDrawable)paramResources.getBackground();
        if (localObject1 != null)
        {
          ((GradientDrawable)localObject1).setAlpha(Math.round(localanbr.a() * 255.0F));
          if (TextUtils.isEmpty(localanbr.a())) {}
        }
        try
        {
          ((GradientDrawable)localObject1).setColor(a(localanbr.a()));
          if (TextUtils.isEmpty(localanbr.c())) {}
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          try
          {
            ((TextView)localView.findViewById(2131378070)).setTextColor(a(localanbr.c()));
            if (!TextUtils.isEmpty(localanbr.b())) {
              ((TextView)localView.findViewById(2131378070)).setText(localanbr.b());
            }
            if (!TextUtils.isEmpty(localanbr.d()))
            {
              localObject1 = (URLImageView)localView.findViewById(2131368513);
              localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              ((URLImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(localanbr.d(), localURLDrawableOptions));
            }
            localView.setOnClickListener(new apvw(paramQQAppInterface, localanbr.e(), paramapvy, localanbr));
            if (localanbr.b() == 2) {
              paramapvy.a((ImageView)localView.findViewById(2131378600));
            }
            axqw.b(paramQQAppInterface, "dc00898", "", "", localanbr.f(), localanbr.f(), 0, 0, "", "", "", "");
            paramResources.addView(localView);
            continue;
            localNumberFormatException1 = localNumberFormatException1;
            QLog.e("TencentDocConvertABTestUtil", 1, "parse bg color fail", localNumberFormatException1);
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            for (;;)
            {
              QLog.e("TencentDocConvertABTestUtil", 1, "parse text color fail", localNumberFormatException2);
            }
          }
        }
      case 2: 
        paramView.setVisibility(0);
        localViewGroup.setVisibility(0);
        localView = localLayoutInflater.inflate(2131560492, paramResources, false);
        Object localObject2 = (LayerDrawable)localViewGroup.getBackground();
        if (localObject2 != null)
        {
          localObject2 = (GradientDrawable)((LayerDrawable)localObject2).findDrawableByLayerId(2131362999);
          ((GradientDrawable)localObject2).setAlpha(Math.round(localanbr.a() * 255.0F));
          if (TextUtils.isEmpty(localanbr.a())) {}
        }
        try
        {
          ((GradientDrawable)localObject2).setColor(a(localanbr.a()));
          if (TextUtils.isEmpty(localanbr.c())) {}
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          try
          {
            ((TextView)localView.findViewById(2131378070)).setTextColor(a(localanbr.c()));
            if (!TextUtils.isEmpty(localanbr.b())) {
              ((TextView)localView.findViewById(2131378070)).setText(localanbr.b());
            }
            if (!TextUtils.isEmpty(localanbr.d()))
            {
              localObject2 = (URLImageView)localView.findViewById(2131368513);
              localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              ((URLImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(localanbr.d(), localURLDrawableOptions));
            }
            localView.setOnClickListener(new apvx(paramQQAppInterface, localanbr.e(), paramapvy, localanbr));
            if (localanbr.b() == 2) {
              paramapvy.a((ImageView)localView.findViewById(2131378600));
            }
            axqw.b(paramQQAppInterface, "dc00898", "", "", localanbr.f(), localanbr.f(), 0, 0, "", "", "", "");
            localViewGroup.addView(localView);
            continue;
            localNumberFormatException3 = localNumberFormatException3;
            QLog.e("TencentDocConvertABTestUtil", 1, "parse bg color fail", localNumberFormatException3);
          }
          catch (NumberFormatException localNumberFormatException4)
          {
            for (;;)
            {
              QLog.e("TencentDocConvertABTestUtil", 1, "parse text color fail", localNumberFormatException4);
            }
          }
        }
      }
    }
  }
  
  public static boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    return (paramTeamWorkFileImportInfo != null) && (a(paramTeamWorkFileImportInfo.b));
  }
  
  public static boolean a(String paramString)
  {
    paramString = a(paramString);
    return (paramString != null) && (paramString.size() > 0) && (((anbr)paramString.get(0)).a() != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apvv
 * JD-Core Version:    0.7.0.1
 */