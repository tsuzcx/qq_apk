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

public class apeb
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
  
  public static List<amln> a()
  {
    return (List)amlo.a().a().get("wording");
  }
  
  private static List<amln> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = apdh.a(paramString).toLowerCase().replace(".", "");
    return (List)amlo.a().a().get(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, View paramView, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, apee paramapee)
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
          localObject = (amln)paramTeamWorkFileImportInfo.next();
          if (((amln)localObject).b() != 2) {
            localArrayList.add(localObject);
          }
        }
      }
      localArrayList.addAll((Collection)localObject);
    }
    a(paramQQAppInterface, paramActivity, paramView, localArrayList, paramapee);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Resources paramResources, View paramView, List<amln> paramList, apee paramapee)
  {
    if ((paramView == null) || (paramapee == null) || (paramList == null) || (paramList.size() == 0)) {}
    ViewGroup localViewGroup;
    do
    {
      return;
      paramResources = (ViewGroup)paramView.findViewById(2131300770);
      localViewGroup = (ViewGroup)paramView.findViewById(2131297806);
    } while ((paramResources == null) || (localViewGroup == null));
    paramView.setVisibility(8);
    paramResources.setVisibility(8);
    localViewGroup.setVisibility(8);
    LayoutInflater localLayoutInflater = (LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      amln localamln = (amln)paramList.next();
      View localView;
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      switch (localamln.a())
      {
      default: 
        QLog.w("TencentDocConvertABTestUtil", 2, "can not show edit entrance");
        break;
      case 1: 
        paramView.setVisibility(0);
        paramResources.setVisibility(0);
        localView = localLayoutInflater.inflate(2131494919, paramResources, false);
        Object localObject1 = (GradientDrawable)paramResources.getBackground();
        if (localObject1 != null)
        {
          ((GradientDrawable)localObject1).setAlpha(Math.round(localamln.a() * 255.0F));
          if (TextUtils.isEmpty(localamln.a())) {}
        }
        try
        {
          ((GradientDrawable)localObject1).setColor(a(localamln.a()));
          if (TextUtils.isEmpty(localamln.c())) {}
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          try
          {
            ((TextView)localView.findViewById(2131312247)).setTextColor(a(localamln.c()));
            if (!TextUtils.isEmpty(localamln.b())) {
              ((TextView)localView.findViewById(2131312247)).setText(localamln.b());
            }
            if (!TextUtils.isEmpty(localamln.d()))
            {
              localObject1 = (URLImageView)localView.findViewById(2131302889);
              localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              ((URLImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(localamln.d(), localURLDrawableOptions));
            }
            localView.setOnClickListener(new apec(paramQQAppInterface, localamln.e(), paramapee, localamln));
            if (localamln.b() == 2) {
              paramapee.a((ImageView)localView.findViewById(2131312776));
            }
            awqx.b(paramQQAppInterface, "dc00898", "", "", localamln.f(), localamln.f(), 0, 0, "", "", "", "");
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
        localView = localLayoutInflater.inflate(2131494919, paramResources, false);
        Object localObject2 = (LayerDrawable)localViewGroup.getBackground();
        if (localObject2 != null)
        {
          localObject2 = (GradientDrawable)((LayerDrawable)localObject2).findDrawableByLayerId(2131297459);
          ((GradientDrawable)localObject2).setAlpha(Math.round(localamln.a() * 255.0F));
          if (TextUtils.isEmpty(localamln.a())) {}
        }
        try
        {
          ((GradientDrawable)localObject2).setColor(a(localamln.a()));
          if (TextUtils.isEmpty(localamln.c())) {}
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          try
          {
            ((TextView)localView.findViewById(2131312247)).setTextColor(a(localamln.c()));
            if (!TextUtils.isEmpty(localamln.b())) {
              ((TextView)localView.findViewById(2131312247)).setText(localamln.b());
            }
            if (!TextUtils.isEmpty(localamln.d()))
            {
              localObject2 = (URLImageView)localView.findViewById(2131302889);
              localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              ((URLImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(localamln.d(), localURLDrawableOptions));
            }
            localView.setOnClickListener(new aped(paramQQAppInterface, localamln.e(), paramapee, localamln));
            if (localamln.b() == 2) {
              paramapee.a((ImageView)localView.findViewById(2131312776));
            }
            awqx.b(paramQQAppInterface, "dc00898", "", "", localamln.f(), localamln.f(), 0, 0, "", "", "", "");
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
    return (paramString != null) && (paramString.size() > 0) && (((amln)paramString.get(0)).a() != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apeb
 * JD-Core Version:    0.7.0.1
 */