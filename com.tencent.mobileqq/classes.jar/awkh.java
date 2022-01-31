import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class awkh
  extends awke
  implements baxz, bfos
{
  protected int a;
  private awtk jdField_a_of_type_Awtk = new awtk();
  private baxy jdField_a_of_type_Baxy;
  private bfos jdField_a_of_type_Bfos;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  public int b = -1;
  
  public awkh(ListView paramListView, baxy parambaxy, bfos parambfos, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Baxy = parambaxy;
    parambaxy.a(this);
    paramListView.setOnScrollListener(this);
    this.jdField_a_of_type_Bfos = parambfos;
    this.b = paramInt;
  }
  
  private awtc a(int paramInt)
  {
    awog localawog = a(paramInt);
    if (localawog == null) {
      return null;
    }
    if (!(localawog instanceof awtc)) {
      return null;
    }
    return (awtc)localawog;
  }
  
  private void a(int paramInt, View paramView, awog paramawog)
  {
    if ((paramView == null) || (paramawog == null)) {}
    for (;;)
    {
      return;
      if ((paramawog instanceof awpo))
      {
        paramView = (awws)paramView.getTag(2131379218);
        if ((paramView instanceof awte)) {}
        for (paramView = ((awte)paramView).a(); paramView != null; paramView = null)
        {
          this.jdField_a_of_type_Awtk.a(paramInt, paramView);
          return;
        }
      }
    }
  }
  
  private boolean a(View paramView, awog paramawog)
  {
    if ((paramView == null) || (paramawog == null)) {
      return false;
    }
    if ((paramawog instanceof awpo))
    {
      awws localawws = (awws)paramView.getTag(2131379218);
      paramView = null;
      if ((localawws instanceof awte)) {
        paramView = ((awte)localawws).a();
      }
      if (paramView == null) {
        return false;
      }
      if ((((awpo)paramawog).f() != paramView.c()) || (((awpo)paramawog).h() != paramView.b())) {
        break label100;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "reuse contentview");
      }
    }
    return true;
    label100:
    return false;
  }
  
  private boolean a(View paramView, awog paramawog, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt2 == 59)
    {
      if (paramView == null) {
        break label203;
      }
      paramView = (awws)paramView.getTag(2131379218);
      if (!(paramView instanceof awte)) {
        break label71;
      }
      paramView = (awte)paramView;
    }
    for (;;)
    {
      if ((paramView != null) && ((paramView instanceof awto)))
      {
        if (paramInt1 != 0) {
          break label76;
        }
        ((awto)paramView).a(false);
      }
      for (;;)
      {
        if ((paramInt1 < 1) || (paramInt3 != 59))
        {
          label68:
          return paramBoolean;
          label71:
          paramView = null;
          break;
          label76:
          if (paramInt1 == 1)
          {
            localObject = a(paramInt1 - 1);
            if ((!(localObject instanceof awnp)) || (((awnp)localObject).jdField_a_of_type_Boolean)) {
              break label197;
            }
          }
        }
      }
      label167:
      label197:
      for (Object localObject = ((awnp)localObject).a().a();; localObject = null)
      {
        if ((paramawog != null) && (localObject != null) && (((List)localObject).contains(paramawog))) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 == 0) {
            break label167;
          }
          ((awto)paramView).a(false);
          break;
        }
        break;
        paramView = a(paramInt1 - 1);
        if ((!(paramView instanceof awta)) || (((awta)paramView).a() != 1)) {
          break label68;
        }
        return true;
      }
      label203:
      paramView = null;
    }
  }
  
  public int a(int paramInt)
  {
    if ((a(paramInt) instanceof awnf)) {
      return ((awnf)a(paramInt)).b();
    }
    if ((a(paramInt) instanceof awng)) {
      return ((awng)a(paramInt)).d();
    }
    return 0;
  }
  
  protected awrd a(int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    case 1: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 28: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 37: 
    case 43: 
    case 58: 
    default: 
      return new awrx(this.jdField_a_of_type_Baxy);
    case 41: 
      return new awrb(this.jdField_a_of_type_Baxy);
    case 3: 
      return new awrt(this.jdField_a_of_type_Baxy, false);
    case 12: 
      return new awrt(this.jdField_a_of_type_Baxy, true);
    case 57: 
      return new awqx();
    case 0: 
      return new awry();
    case 49: 
      return new awrr();
    case 15: 
      return new awry();
    case 2: 
    case 8: 
      return new awrm(this.jdField_a_of_type_Baxy);
    case 9: 
      return new awrv();
    case 14: 
      return new awrv();
    case 10: 
      return new bgqr();
    case 11: 
      return new apfm(this.jdField_a_of_type_Baxy);
    case 13: 
      return new awqo(this.jdField_a_of_type_Baxy);
    case 56: 
      return new awre(this.jdField_a_of_type_Baxy);
    case 60: 
      return new awri(this.jdField_a_of_type_Baxy);
    case 16: 
      return new awrx(this.jdField_a_of_type_Baxy);
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 31: 
    case 40: 
      return new awqj(this.jdField_a_of_type_Baxy, a(paramInt), this);
    case 29: 
    case 30: 
    case 36: 
      return new awqy();
    case 38: 
    case 39: 
    case 42: 
    case 44: 
    case 45: 
    case 47: 
    case 48: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 61: 
    case 62: 
      return new awsc(this.jdField_a_of_type_Baxy, this);
    case 46: 
      return new awrn(this.jdField_a_of_type_Baxy);
    }
    return new awro(this.jdField_a_of_type_Baxy, this);
  }
  
  protected awws a(int paramInt, ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    Object localObject1;
    switch (getItemViewType(paramInt))
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 11: 
    case 18: 
    case 20: 
    case 28: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 37: 
    case 43: 
    case 58: 
    default: 
      return new awyg(paramViewGroup, 2131562370);
    case 41: 
      return new awwo(paramViewGroup);
    case 3: 
      return new awyc(paramViewGroup);
    case 12: 
      return new awya(paramViewGroup);
    case 57: 
      return new awwm(paramViewGroup);
    case 0: 
    case 15: 
      localObject1 = a(paramInt);
      if (!(localObject1 instanceof awnp)) {
        break;
      }
    }
    for (boolean bool1 = ((awnp)localObject1).a();; bool1 = false)
    {
      if (paramInt != 0) {
        bool2 = true;
      }
      return new awye(paramViewGroup, bool2, bool1);
      return new awyg(paramViewGroup, 2131559450);
      return new awyb(paramViewGroup);
      return new awyd(paramViewGroup, 2131562390, 2130845183, -1);
      return new awyd(paramViewGroup, 2131562390, 2130845183, 12);
      return new awyh(paramViewGroup, 2131559645);
      return new awwj(paramViewGroup, 2131562374);
      return new awwt(paramViewGroup, 2131562376);
      return new awwv(paramViewGroup, 2131562377);
      return new awwi(paramViewGroup, 2131562419);
      return new awyg(paramViewGroup, 2131562371);
      return new awyg(paramViewGroup, 2131562378);
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = a(paramInt);
      localObject2 = awtm.a().a((QQAppInterface)localObject2, paramViewGroup.getContext(), (awog)localObject1);
      if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof awpo))) {
        ((awpo)localObject1).c(((awtc)localObject2).b());
      }
      if (localObject2 == null) {
        return new awwm(paramViewGroup);
      }
      return ((awtc)localObject2).a();
      return new awxz(paramViewGroup, a(paramInt));
      localObject1 = a(paramInt);
      if ((localObject1 instanceof awpr)) {
        return new awxy(paramViewGroup, ((awpr)localObject1).d());
      }
      throw new RuntimeException("model type is TYPE_UNITE_ENTRANCE_SUB_ITEM_COMMON_TEXT, but model item is not instance SearchResultModelForEntrance.");
      localObject1 = a(paramInt);
      if ((localObject1 instanceof awor))
      {
        localObject1 = (awor)localObject1;
        switch (((awor)localObject1).d())
        {
        case 5: 
        case 10: 
        default: 
          throw new RuntimeException("NetSearchTemplateBaseItem.getLayoutId() is " + ((awor)localObject1).e() + " which is not supported!!!");
        case 2: 
          return new awww(paramViewGroup, ((awor)localObject1).e());
        case 3: 
          return new awxs(paramViewGroup, ((awor)localObject1).e());
        case 4: 
          return new awwx(paramViewGroup, ((awor)localObject1).e());
        case 7: 
          return new awxe(paramViewGroup, ((awor)localObject1).e());
        case 6: 
          return new awxr(paramViewGroup, ((awor)localObject1).e());
        case 8: 
          return new awxp(paramViewGroup, ((awor)localObject1).e());
        case 9: 
          return new awxo(paramViewGroup, ((awor)localObject1).e());
        case 11: 
          return new awxb(paramViewGroup, ((awor)localObject1).e());
        case 12: 
          return new awwz(paramViewGroup, ((awor)localObject1).e());
        case 13: 
          return new awxc(paramViewGroup, ((awor)localObject1).e());
        case 14: 
          return new awxq(paramViewGroup, ((awor)localObject1).e());
        case 15: 
          return new awxm(paramViewGroup, ((awor)localObject1).e());
        case 16: 
          return new awxh(paramViewGroup, ((awor)localObject1).e());
        case 17: 
          return new awxj(paramViewGroup, ((awor)localObject1).e());
        }
        return new awxg(paramViewGroup, ((awor)localObject1).e());
      }
      throw new RuntimeException("model type is TYPE_UNITE_TEMPLATE_NORMAL or TYPE_UNITE_TEMPLATE_NEWS, but model item is not instance NetSearchTemplateBaseItem.");
      return new awyh(paramViewGroup, 2131559451);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 12;
    if ((super.a(paramInt) instanceof awnr)) {
      i = 41;
    }
    do
    {
      return i;
      if ((super.a(paramInt) instanceof awnv)) {
        return 3;
      }
    } while ((super.a(paramInt) instanceof awma));
    if (((super.a(paramInt) instanceof awnp)) && (this.b != 12))
    {
      if (((awnp)super.a(paramInt)).jdField_a_of_type_Boolean) {
        return 0;
      }
      return 57;
    }
    if (((super.a(paramInt) instanceof awnp)) && (this.b == 12))
    {
      if (((awnp)super.a(paramInt)).jdField_a_of_type_Boolean) {
        return 15;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof awnq))
    {
      awnq localawnq = (awnq)super.a(paramInt);
      if ((localawnq != null) && (localawnq.jdField_a_of_type_Boolean)) {
        return 49;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof awoa)) {
      return 2;
    }
    if ((super.a(paramInt) instanceof awnj)) {
      return 5;
    }
    if ((super.a(paramInt) instanceof awnw)) {
      return 56;
    }
    if ((super.a(paramInt) instanceof awnn)) {
      return 6;
    }
    if ((super.a(paramInt) instanceof awny)) {
      return 60;
    }
    if ((super.a(paramInt) instanceof awnl)) {
      return 8;
    }
    if ((super.a(paramInt) instanceof awnh)) {
      return 16;
    }
    if (((super.a(paramInt) instanceof awnx)) && (this.b != 12)) {
      return 9;
    }
    if (((super.a(paramInt) instanceof awnx)) && (this.b == 12)) {
      return 14;
    }
    if ((a(paramInt) instanceof bgqv)) {
      return 10;
    }
    if ((a(paramInt) instanceof apfp)) {
      return 11;
    }
    if (((super.a(paramInt) instanceof awns)) || ((super.a(paramInt) instanceof awnu))) {
      return 13;
    }
    if ((a(paramInt) instanceof awnz)) {
      return 17;
    }
    if ((a(paramInt) instanceof awnt)) {
      return 19;
    }
    if ((a(paramInt) instanceof awpo)) {
      return 59;
    }
    if ((a(paramInt) instanceof awng))
    {
      switch (((awng)a(paramInt)).d())
      {
      default: 
        return 25;
      case 268435456: 
        return 26;
      case 1001: 
        return 21;
      }
      return 22;
    }
    if ((a(paramInt) instanceof awpr))
    {
      switch (((awpr)a(paramInt)).jdField_a_of_type_Int)
      {
      case -2: 
      default: 
        return 29;
      case -1: 
        return 29;
      case -3: 
        return 30;
      }
      return 36;
    }
    if ((a(paramInt) instanceof awor))
    {
      switch (((awor)a(paramInt)).d())
      {
      case 5: 
      case 10: 
      default: 
        return 45;
      case 2: 
        return 38;
      case 3: 
        return 39;
      case 4: 
        return 42;
      case 7: 
        return 44;
      case 6: 
        return 45;
      case 8: 
        return 47;
      case 9: 
        return 48;
      case 11: 
        return 50;
      case 12: 
        return 51;
      case 13: 
        return 52;
      case 14: 
        return 53;
      case 15: 
        return 54;
      case 16: 
        return 55;
      case 17: 
        return 61;
      }
      return 62;
    }
    if ((a(paramInt) instanceof awpm)) {
      return 46;
    }
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    awog localawog = a(paramInt);
    Object localObject3;
    int j;
    Object localObject6;
    Object localObject7;
    Object localObject2;
    if (awiw.a(localawog) > 0)
    {
      Object localObject1;
      if (awiw.b.containsKey(localawog))
      {
        localObject1 = (awix)awiw.b.get(localawog);
        if (!((awix)localObject1).jdField_a_of_type_Boolean)
        {
          ((awix)localObject1).jdField_a_of_type_Boolean = true;
          localObject3 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject3).put("project", awsq.a());
        ((JSONObject)localObject3).put("event_src", "client");
        ((JSONObject)localObject3).put("get_src", "native");
        ((JSONObject)localObject3).put("obj_lct", ((awix)localObject1).jdField_a_of_type_Int);
        localObject4 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        awsq.a((QQAppInterface)localObject4, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((awix)localObject1).jdField_a_of_type_Long + "").obj2(((awix)localObject1).jdField_b_of_type_JavaLangString).ver1(((awix)localObject1).jdField_a_of_type_JavaLangString).ver2(awsq.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject4).getCurrentAccountUin() + awiw.jdField_a_of_type_Long));
        ((awix)localObject1).jdField_a_of_type_Boolean = true;
        awiw.b.put(localawog, localObject1);
        if ((localawog instanceof awoh))
        {
          localObject1 = (awoh)localawog;
          localObject3 = ((awoh)localObject1).a();
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            j = Math.min(((List)localObject3).size(), ((awoh)localObject1).a());
            i = 0;
            if (i < j) {
              if (awiw.b.containsKey(((List)localObject3).get(i)))
              {
                localObject4 = (awix)awiw.b.get(((List)localObject3).get(i));
                if (!((awix)localObject4).jdField_a_of_type_Boolean)
                {
                  ((awix)localObject4).jdField_a_of_type_Boolean = true;
                  localObject6 = new JSONObject();
                }
              }
            }
          }
        }
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          for (;;)
          {
            Object localObject4;
            ((JSONObject)localObject6).put("project", awsq.a());
            ((JSONObject)localObject6).put("event_src", "client");
            ((JSONObject)localObject6).put("get_src", "native");
            ((JSONObject)localObject6).put("obj_lct", ((awix)localObject4).jdField_a_of_type_Int);
            if (!(((List)localObject3).get(i) instanceof awon)) {
              break label716;
            }
            localObject7 = (awon)((List)localObject3).get(i);
            if (!((awon)localObject7).c()) {
              break;
            }
            localObject1 = "1";
            ((awix)localObject4).jdField_b_of_type_JavaLangString = ((awon)localObject7).e();
            localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            awsq.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((awix)localObject4).jdField_a_of_type_Long + "").obj2(((awix)localObject4).jdField_b_of_type_JavaLangString).ver1(((awix)localObject4).jdField_a_of_type_JavaLangString).ver2(awsq.a(this.b)).ver3((String)localObject1).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + awiw.jdField_a_of_type_Long));
            ((awix)localObject4).jdField_a_of_type_Boolean = true;
            awiw.b.put(((List)localObject3).get(i), localObject4);
            i += 1;
          }
          localJSONException2 = localJSONException2;
          QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException2);
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException1);
            continue;
            localObject2 = "0";
            continue;
            label716:
            localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            awsq.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localJSONException2.jdField_a_of_type_Long + "").obj2(localJSONException2.jdField_b_of_type_JavaLangString).ver1(localJSONException2.jdField_a_of_type_JavaLangString).ver2(awsq.a(this.b)).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + awiw.jdField_a_of_type_Long));
            localJSONException2.jdField_a_of_type_Boolean = true;
            awiw.b.put(((List)localObject3).get(i), localJSONException2);
          }
        }
      }
    }
    Object localObject5;
    if ((localawog instanceof awnf))
    {
      localObject2 = (awnf)localawog;
      if ((((awnf)localObject2).a() != null) && (((awnf)localObject2).a().size() > 0))
      {
        i = 0;
        for (;;)
        {
          if (i >= ((awnf)localObject2).a().size()) {
            break label1809;
          }
          localObject3 = (awog)((awnf)localObject2).a().get(i);
          if (awiw.b.containsKey(localObject3))
          {
            localObject3 = (awix)awiw.b.get(localObject3);
            if (!((awix)localObject3).jdField_a_of_type_Boolean)
            {
              ((awix)localObject3).jdField_a_of_type_Boolean = true;
              localObject5 = new JSONObject();
            }
          }
          try
          {
            ((JSONObject)localObject5).put("project", awsq.a());
            ((JSONObject)localObject5).put("event_src", "client");
            ((JSONObject)localObject5).put("get_src", "web");
            ((JSONObject)localObject5).put("obj_lct", ((awix)localObject3).jdField_a_of_type_Int);
            localObject6 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            awsq.a((QQAppInterface)localObject6, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((awix)localObject3).jdField_a_of_type_Long + "").obj2(((awix)localObject3).jdField_b_of_type_JavaLangString).ver1(((awix)localObject3).jdField_a_of_type_JavaLangString).ver2(awsq.a(this.b)).ver7(((JSONObject)localObject5).toString()).session_id(((QQAppInterface)localObject6).getCurrentAccountUin() + awiw.jdField_a_of_type_Long));
            i += 1;
          }
          catch (JSONException localJSONException4)
          {
            for (;;)
            {
              QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException4);
            }
          }
        }
      }
    }
    else if ((localawog instanceof awoy))
    {
      localObject2 = ((awoy)localawog).a;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1809;
          }
          localObject3 = (awox)((Iterator)localObject2).next();
          if (awiw.b.containsKey(localObject3))
          {
            localObject5 = (awix)awiw.b.get(localObject3);
            if (!((awix)localObject5).jdField_a_of_type_Boolean)
            {
              ((awix)localObject5).jdField_a_of_type_Boolean = true;
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("project", awsq.a());
                localJSONObject.put("event_src", "client");
                localJSONObject.put("get_src", "web");
                localJSONObject.put("obj_lct", ((awix)localObject5).jdField_a_of_type_Int);
                localJSONObject.put("extra_info", ((awox)localObject3).jdField_b_of_type_JavaLangString);
                localJSONObject.put("tepl", ((awox)localObject3).f);
                localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                awsq.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((awox)localObject3).jdField_a_of_type_Long + "").obj2(((awox)localObject3).j).ver1(((awix)localObject5).jdField_a_of_type_JavaLangString).ver2(awsq.a(this.b)).ver7(localJSONObject.toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + awiw.jdField_a_of_type_Long));
              }
              catch (JSONException localJSONException5)
              {
                for (;;)
                {
                  QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException5);
                }
              }
            }
          }
        }
      }
    }
    else
    {
      if (!(localawog instanceof awpb)) {
        break label2257;
      }
      if (awiw.b.containsKey(localawog))
      {
        localObject2 = (awix)awiw.b.get(localawog);
        localObject3 = (awpb)localawog;
        if (!((awix)localObject2).jdField_a_of_type_Boolean)
        {
          ((awix)localObject2).jdField_a_of_type_Boolean = true;
          localObject5 = new StringBuilder();
          if ((((awpb)localObject3).a != null) && (((awpb)localObject3).a.size() > 0))
          {
            i = 0;
            if (i < ((awpb)localObject3).a.size())
            {
              if (i != ((awpb)localObject3).a.size() - 1) {
                ((StringBuilder)localObject5).append(((awoo)((awpb)localObject3).a.get(i)).jdField_b_of_type_JavaLangString).append("::");
              }
              for (;;)
              {
                i += 1;
                break;
                ((StringBuilder)localObject5).append(((awoo)((awpb)localObject3).a.get(i)).jdField_b_of_type_JavaLangString);
              }
            }
          }
          awsq.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((awix)localObject2).jdField_a_of_type_JavaLangString).ver2(awsq.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + awsq.jdField_b_of_type_JavaLangString + "}"));
        }
      }
    }
    label1809:
    if (awiw.jdField_a_of_type_JavaUtilHashMap.containsKey(localawog))
    {
      localObject2 = (awix)awiw.jdField_a_of_type_JavaUtilHashMap.get(localawog);
      if (!((awix)localObject2).jdField_a_of_type_Boolean)
      {
        if (awwa.a(((awix)localObject2).jdField_a_of_type_Long))
        {
          if (!((awix)localObject2).jdField_b_of_type_Boolean) {
            break label2874;
          }
          i = 2;
          label1863:
          awwa.a("all_result", "exp_object", i, 0, new String[] { ((awix)localObject2).jdField_a_of_type_JavaLangString, ((awix)localObject2).jdField_a_of_type_Long + "", ((awix)localObject2).jdField_b_of_type_JavaLangString, ((awix)localObject2).jdField_a_of_type_Int + "" });
          ((awix)localObject2).jdField_a_of_type_Boolean = true;
          awiw.jdField_a_of_type_JavaUtilHashMap.put((awoi)localawog, localObject2);
        }
        if ((localawog instanceof awpr))
        {
          localObject3 = (awpr)localawog;
          if ((((awpr)localObject3).jdField_a_of_type_Int == -3) || (((awpr)localObject3).jdField_a_of_type_Int == -4)) {
            if (!((awix)localObject2).jdField_b_of_type_Boolean) {
              break label2880;
            }
          }
        }
      }
    }
    label2874:
    label2880:
    for (int i = 2;; i = 1)
    {
      for (;;)
      {
        awwa.a("all_result", "exp_net_search", i, 0, new String[] { ((awix)localObject2).jdField_a_of_type_JavaLangString, ((awix)localObject2).jdField_a_of_type_Long + "", ((awix)localObject2).jdField_b_of_type_JavaLangString, ((awix)localObject2).jdField_a_of_type_Int + "" });
        localObject2 = paramView;
        if (!a(paramView, localawog)) {
          localObject2 = null;
        }
        paramView = super.getView(paramInt, (View)localObject2, paramViewGroup);
        a(paramInt, paramView, localawog);
        boolean bool1 = false;
        if (paramInt == 0) {
          bool1 = true;
        }
        boolean bool2 = bool1;
        if (paramInt >= 1)
        {
          i = getItemViewType(paramInt);
          j = getItemViewType(paramInt - 1);
          if (i != 11)
          {
            bool2 = bool1;
            if (i != 10) {}
          }
          else if (j != 11)
          {
            bool2 = bool1;
            if (j != 10) {}
          }
          else
          {
            bool2 = true;
          }
          bool2 = a(paramView, localawog, paramInt, i, j, bool2);
        }
        if ((paramView != null) && (paramView.findViewById(2131365282) != null))
        {
          if (!bool2) {
            break label2886;
          }
          paramView.findViewById(2131365282).setVisibility(8);
        }
        return paramView;
        label2257:
        if (((!(localawog instanceof awor)) || ((localawog instanceof awpf))) && (((!(localawog instanceof awng)) && ((!(localawog instanceof awpr)) || (((awpr)localawog).jdField_a_of_type_Int != -4))) || (!awiw.b.containsKey(localawog)))) {
          break;
        }
        localObject2 = (awix)awiw.b.get(localawog);
        if ((localawog instanceof awpc))
        {
          localObject3 = (awpc)localawog;
          if (!((awix)localObject2).jdField_a_of_type_Boolean)
          {
            ((awix)localObject2).jdField_a_of_type_Boolean = true;
            localObject5 = new StringBuilder();
            if ((((awpc)localObject3).a != null) && (((awpc)localObject3).a.size() > 0))
            {
              i = 0;
              while (i < ((awpc)localObject3).a.size())
              {
                ((StringBuilder)localObject5).append(((awpn)((awpc)localObject3).a.get(i)).jdField_a_of_type_JavaLangString).append("::");
                i += 1;
              }
              awsq.a(null, new ReportModelDC02528().module("all_result").action("exp_relatedsearch_list").obj1("1007").ver1(((awix)localObject2).jdField_a_of_type_JavaLangString).ver2(awsq.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + awsq.jdField_b_of_type_JavaLangString + "}"));
            }
            awsq.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((awix)localObject2).jdField_a_of_type_JavaLangString).ver2(awsq.a(this.b)).ver5("2").ver7("{experiment_id:" + awsq.jdField_b_of_type_JavaLangString + "}"));
          }
        }
        if (((awix)localObject2).jdField_a_of_type_Boolean) {
          break;
        }
        ((awix)localObject2).jdField_a_of_type_Boolean = true;
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("project", awsq.a());
          ((JSONObject)localObject3).put("event_src", "client");
          ((JSONObject)localObject3).put("get_src", "web");
          ((JSONObject)localObject3).put("obj_lct", ((awix)localObject2).jdField_a_of_type_Int);
          if ((localawog instanceof awor)) {
            ((JSONObject)localObject3).put("tepl", ((awor)localawog).f);
          }
          localObject5 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          awsq.a((QQAppInterface)localObject5, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((awix)localObject2).jdField_a_of_type_Long + "").obj2(((awix)localObject2).jdField_b_of_type_JavaLangString).ver1(((awix)localObject2).jdField_a_of_type_JavaLangString).ver2(awsq.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject5).getCurrentAccountUin() + awiw.jdField_a_of_type_Long));
        }
        catch (JSONException localJSONException3)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException3);
          }
        }
      }
      i = 1;
      break label1863;
    }
    label2886:
    paramView.findViewById(2131365282).setVisibility(0);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 63;
  }
  
  public void notifyDataSetChanged()
  {
    int i1 = getCount();
    int n = 0;
    int j = 0;
    int k = 0;
    int i = 0;
    if (n < i1)
    {
      Object localObject = a(n);
      int m;
      if ((localObject instanceof awnp))
      {
        localObject = (awnp)localObject;
        k = i + 1;
        ((awnp)localObject).a(1, k);
        i = j;
        if (((awnp)localObject).b() == 2) {
          i = j + 1;
        }
        ((awnp)localObject).a(3, i);
        ((awnp)localObject).a(0, k, i);
        m = 0;
        j = k;
        k = i;
        i = m;
      }
      for (;;)
      {
        n += 1;
        m = j;
        j = k;
        k = i;
        i = m;
        break;
        if ((localObject instanceof awpq))
        {
          localObject = (awpq)localObject;
          k += 1;
          ((awpq)localObject).a(k, i, j);
          m = i;
          i = k;
          k = j;
          j = m;
        }
        else
        {
          m = k;
          if ((localObject instanceof awng))
          {
            localObject = (awng)localObject;
            m = k + 1;
            ((awng)localObject).a(m, i, j);
          }
          k = m;
          m = i;
          i = k;
          k = j;
          j = m;
        }
      }
    }
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "onDecodeTaskCompleted, remainingTasks : " + paramInt1 + ", type : " + paramInt2 + ", uin : " + paramString + ", avatar : " + paramBitmap + ", mFaceDecoder.isPausing() : " + this.jdField_a_of_type_Baxy.a() + ", mScrollState : " + this.jdField_a_of_type_Int);
    }
    if ((!this.jdField_a_of_type_Baxy.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1);
        awof localawof;
        awrc localawrc;
        awwp localawwp;
        if (((localView.getTag(2131379213) instanceof awof)) && ((localView.getTag(2131379215) instanceof awrc)) && ((localView.getTag(2131379218) instanceof awwp)))
        {
          localawof = (awof)localView.getTag(2131379213);
          localawrc = (awrc)localView.getTag(2131379215);
          localawwp = (awwp)localView.getTag(2131379218);
          if ((localawof.c() == paramInt2) && (paramString.equals(localawof.b()))) {
            localawrc.a(localawof, localawwp, paramBitmap);
          }
        }
        if ((localView instanceof ViewGroup))
        {
          int i = 0;
          while (i < ((ViewGroup)localView).getChildCount())
          {
            localawof = (awof)((ViewGroup)localView).getChildAt(i).getTag(2131379213);
            if ((localawof != null) && (localawof.c() == paramInt2) && (paramString.equals(localawof.b())))
            {
              localawrc = (awrc)((ViewGroup)localView).getChildAt(i).getTag(2131379215);
              localawwp = (awwp)((ViewGroup)localView).getChildAt(i).getTag(2131379218);
              if ((localawrc != null) && (localawwp != null)) {
                localawrc.a(localawof, localawwp, paramBitmap);
              }
            }
            i += 1;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bfos != null) {
      this.jdField_a_of_type_Bfos.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    this.jdField_a_of_type_Awtk.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    int k;
    int i;
    if ((paramInt == 0) || (paramInt == 1))
    {
      if (this.jdField_a_of_type_Baxy.a()) {
        this.jdField_a_of_type_Baxy.b();
      }
      k = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      i = 0;
    }
    while (i < k)
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
      if ((localView instanceof ViewGroup))
      {
        int j = 0;
        while (j < ((ViewGroup)localView).getChildCount())
        {
          awof localawof = (awof)((ViewGroup)localView).getChildAt(j).getTag(2131379213);
          awrc localawrc = (awrc)((ViewGroup)localView).getChildAt(j).getTag(2131379215);
          awwp localawwp = (awwp)((ViewGroup)localView).getChildAt(j).getTag(2131379218);
          if ((localawrc != null) && (localawof != null) && (paramAbsListView != null)) {
            localawrc.a(localawof, localawwp);
          }
          j += 1;
        }
      }
      i += 1;
      continue;
      this.jdField_a_of_type_Baxy.a();
      this.jdField_a_of_type_Baxy.c();
    }
    if (this.jdField_a_of_type_Bfos != null) {
      this.jdField_a_of_type_Bfos.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.jdField_a_of_type_Awtk.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkh
 * JD-Core Version:    0.7.0.1
 */