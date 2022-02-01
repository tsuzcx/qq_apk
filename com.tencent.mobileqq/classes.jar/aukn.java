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
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.minigame.utils.DpUtil;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class aukn
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
  
  public static List<arnm> a()
  {
    return (List)arnn.a().a().get("wording");
  }
  
  private static List<arnm> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = FileUtil.getExtension(paramString).toLowerCase().replace(".", "");
    return (List)arnn.a().a().get(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, View paramView, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, aukq paramaukq)
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
          localObject = (arnm)paramTeamWorkFileImportInfo.next();
          if (((arnm)localObject).b() != 2) {
            localArrayList.add(localObject);
          }
        }
      }
      localArrayList.addAll((Collection)localObject);
    }
    a(paramQQAppInterface, paramActivity, paramView, localArrayList, paramaukq);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Resources paramResources, View paramView, List<arnm> paramList, aukq paramaukq)
  {
    if ((paramView == null) || (paramaukq == null) || (paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramResources = (ViewGroup)paramView.findViewById(2131366949);
      ViewGroup localViewGroup = (ViewGroup)paramView.findViewById(2131363704);
      if ((paramResources != null) && (localViewGroup != null))
      {
        paramView.setVisibility(8);
        paramResources.setVisibility(8);
        localViewGroup.setVisibility(8);
        LayoutInflater localLayoutInflater = (LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          arnm localarnm = (arnm)paramList.next();
          switch (localarnm.a())
          {
          default: 
            QLog.w("TencentDocConvertABTestUtil", 2, "can not show edit entrance");
            break;
          case 1: 
            a(paramQQAppInterface, paramView, paramaukq, paramResources, localLayoutInflater, localarnm);
            break;
          case 2: 
            a(paramQQAppInterface, paramView, paramaukq, paramResources, localViewGroup, localLayoutInflater, localarnm);
          }
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, View paramView, aukq paramaukq, ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, arnm paramarnm)
  {
    paramView.setVisibility(0);
    paramViewGroup.setVisibility(0);
    paramView = paramLayoutInflater.inflate(2131560860, paramViewGroup, false);
    paramLayoutInflater = (GradientDrawable)paramViewGroup.getBackground();
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.setAlpha(Math.round(paramarnm.a() * 255.0F));
      if (TextUtils.isEmpty(paramarnm.a())) {}
    }
    try
    {
      paramLayoutInflater.setColor(a(paramarnm.a()));
      if (TextUtils.isEmpty(paramarnm.c())) {}
    }
    catch (NumberFormatException paramLayoutInflater)
    {
      try
      {
        ((TextView)paramView.findViewById(2131379800)).setTextColor(a(paramarnm.c()));
        if (!TextUtils.isEmpty(paramarnm.b())) {
          ((TextView)paramView.findViewById(2131379800)).setText(paramarnm.b());
        }
        if (!TextUtils.isEmpty(paramarnm.d()))
        {
          paramLayoutInflater = (URLImageView)paramView.findViewById(2131369331);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable(paramarnm.d(), localURLDrawableOptions));
        }
        paramView.setOnClickListener(new aukp(paramQQAppInterface, paramarnm.e(), paramaukq, paramarnm));
        if (paramarnm.b() == 2) {
          paramaukq.a((ImageView)paramView.findViewById(2131380452));
        }
        bdla.b(paramQQAppInterface, "dc00898", "", "", paramarnm.f(), paramarnm.f(), 0, 0, "", "", "", "");
        paramViewGroup.addView(paramView);
        return;
        paramLayoutInflater = paramLayoutInflater;
        QLog.e("TencentDocConvertABTestUtil", 1, "parse bg color fail", paramLayoutInflater);
      }
      catch (NumberFormatException paramLayoutInflater)
      {
        for (;;)
        {
          QLog.e("TencentDocConvertABTestUtil", 1, "parse text color fail", paramLayoutInflater);
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, View paramView, aukq paramaukq, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, LayoutInflater paramLayoutInflater, arnm paramarnm)
  {
    paramView.setVisibility(0);
    paramViewGroup2.setVisibility(0);
    paramView = paramLayoutInflater.inflate(2131560860, paramViewGroup1, false);
    paramViewGroup1 = (LayerDrawable)paramViewGroup2.getBackground();
    if (paramViewGroup1 != null)
    {
      paramViewGroup1 = (GradientDrawable)paramViewGroup1.findDrawableByLayerId(2131363339);
      paramViewGroup1.setAlpha(Math.round(paramarnm.a() * 255.0F));
      if (TextUtils.isEmpty(paramarnm.a())) {}
    }
    try
    {
      paramViewGroup1.setColor(a(paramarnm.a()));
      if (TextUtils.isEmpty(paramarnm.c())) {}
    }
    catch (NumberFormatException paramViewGroup1)
    {
      try
      {
        ((TextView)paramView.findViewById(2131379800)).setTextColor(a(paramarnm.c()));
        if (!TextUtils.isEmpty(paramarnm.b())) {
          ((TextView)paramView.findViewById(2131379800)).setText(paramarnm.b());
        }
        if (!TextUtils.isEmpty(paramarnm.d()))
        {
          paramViewGroup1 = (URLImageView)paramView.findViewById(2131369331);
          paramLayoutInflater = URLDrawable.URLDrawableOptions.obtain();
          paramViewGroup1.setImageDrawable(URLDrawable.getDrawable(paramarnm.d(), paramLayoutInflater));
        }
        paramView.setOnClickListener(new auko(paramQQAppInterface, paramarnm.e(), paramaukq, paramarnm));
        if (paramarnm.b() == 2) {
          paramaukq.a((ImageView)paramView.findViewById(2131380452));
        }
        bdla.b(paramQQAppInterface, "dc00898", "", "", paramarnm.f(), paramarnm.f(), 0, 0, "", "", "", "");
        paramViewGroup2.addView(paramView);
        return;
        paramViewGroup1 = paramViewGroup1;
        QLog.e("TencentDocConvertABTestUtil", 1, "parse bg color fail", paramViewGroup1);
      }
      catch (NumberFormatException paramViewGroup1)
      {
        for (;;)
        {
          QLog.e("TencentDocConvertABTestUtil", 1, "parse text color fail", paramViewGroup1);
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
    return (paramString != null) && (paramString.size() > 0) && (((arnm)paramString.get(0)).a() != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aukn
 * JD-Core Version:    0.7.0.1
 */