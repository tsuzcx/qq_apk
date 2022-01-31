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

public class ayfh
  extends ayfe
  implements bcwt, bhpo
{
  protected int a;
  private ayon jdField_a_of_type_Ayon = new ayon();
  private bcws jdField_a_of_type_Bcws;
  private bhpo jdField_a_of_type_Bhpo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  public int b = -1;
  
  public ayfh(ListView paramListView, bcws parambcws, bhpo parambhpo, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Bcws = parambcws;
    parambcws.a(this);
    paramListView.setOnScrollListener(this);
    this.jdField_a_of_type_Bhpo = parambhpo;
    this.b = paramInt;
  }
  
  private ayof a(int paramInt)
  {
    ayjj localayjj = a(paramInt);
    if (localayjj == null) {
      return null;
    }
    if (!(localayjj instanceof ayof)) {
      return null;
    }
    return (ayof)localayjj;
  }
  
  private void a(int paramInt, View paramView, ayjj paramayjj)
  {
    if ((paramView == null) || (paramayjj == null)) {}
    for (;;)
    {
      return;
      if ((paramayjj instanceof aykr))
      {
        paramView = (ayrv)paramView.getTag(2131379918);
        if ((paramView instanceof ayoh)) {}
        for (paramView = ((ayoh)paramView).a(); paramView != null; paramView = null)
        {
          this.jdField_a_of_type_Ayon.a(paramInt, paramView);
          return;
        }
      }
    }
  }
  
  private boolean a(View paramView, ayjj paramayjj)
  {
    if ((paramView == null) || (paramayjj == null)) {
      return false;
    }
    if ((paramayjj instanceof aykr))
    {
      ayrv localayrv = (ayrv)paramView.getTag(2131379918);
      paramView = null;
      if ((localayrv instanceof ayoh)) {
        paramView = ((ayoh)localayrv).a();
      }
      if (paramView == null) {
        return false;
      }
      if ((((aykr)paramayjj).f() != paramView.c()) || (((aykr)paramayjj).h() != paramView.b())) {
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
  
  private boolean a(View paramView, ayjj paramayjj, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt2 == 59)
    {
      if (paramView == null) {
        break label203;
      }
      paramView = (ayrv)paramView.getTag(2131379918);
      if (!(paramView instanceof ayoh)) {
        break label71;
      }
      paramView = (ayoh)paramView;
    }
    for (;;)
    {
      if ((paramView != null) && ((paramView instanceof ayor)))
      {
        if (paramInt1 != 0) {
          break label76;
        }
        ((ayor)paramView).a(false);
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
            if ((!(localObject instanceof ayis)) || (((ayis)localObject).jdField_a_of_type_Boolean)) {
              break label197;
            }
          }
        }
      }
      label167:
      label197:
      for (Object localObject = ((ayis)localObject).a().a();; localObject = null)
      {
        if ((paramayjj != null) && (localObject != null) && (((List)localObject).contains(paramayjj))) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 == 0) {
            break label167;
          }
          ((ayor)paramView).a(false);
          break;
        }
        break;
        paramView = a(paramInt1 - 1);
        if ((!(paramView instanceof ayod)) || (((ayod)paramView).a() != 1)) {
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
    if ((a(paramInt) instanceof ayii)) {
      return ((ayii)a(paramInt)).b();
    }
    if ((a(paramInt) instanceof ayij)) {
      return ((ayij)a(paramInt)).d();
    }
    return 0;
  }
  
  protected aymg a(int paramInt)
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
      return new ayna(this.jdField_a_of_type_Bcws);
    case 41: 
      return new ayme(this.jdField_a_of_type_Bcws);
    case 3: 
      return new aymw(this.jdField_a_of_type_Bcws, false);
    case 12: 
      return new aymw(this.jdField_a_of_type_Bcws, true);
    case 57: 
      return new ayma();
    case 0: 
      return new aynb();
    case 49: 
      return new aymu();
    case 15: 
      return new aynb();
    case 2: 
    case 8: 
      return new aymp(this.jdField_a_of_type_Bcws);
    case 9: 
      return new aymy();
    case 14: 
      return new aymy();
    case 10: 
      return new birq();
    case 11: 
      return new aqyk(this.jdField_a_of_type_Bcws);
    case 13: 
      return new aylr(this.jdField_a_of_type_Bcws);
    case 56: 
      return new aymh(this.jdField_a_of_type_Bcws);
    case 60: 
      return new ayml(this.jdField_a_of_type_Bcws);
    case 16: 
      return new ayna(this.jdField_a_of_type_Bcws);
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 31: 
    case 40: 
      return new aylm(this.jdField_a_of_type_Bcws, a(paramInt), this);
    case 29: 
    case 30: 
    case 36: 
      return new aymb();
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
      return new aynf(this.jdField_a_of_type_Bcws, this);
    case 46: 
      return new aymq(this.jdField_a_of_type_Bcws);
    }
    return new aymr(this.jdField_a_of_type_Bcws, this);
  }
  
  protected ayrv a(int paramInt, ViewGroup paramViewGroup)
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
      return new aytj(paramViewGroup, 2131562574);
    case 41: 
      return new ayrr(paramViewGroup);
    case 3: 
      return new aytf(paramViewGroup);
    case 12: 
      return new aytd(paramViewGroup);
    case 57: 
      return new ayrp(paramViewGroup);
    case 0: 
    case 15: 
      localObject1 = a(paramInt);
      if (!(localObject1 instanceof ayis)) {
        break;
      }
    }
    for (boolean bool1 = ((ayis)localObject1).a();; bool1 = false)
    {
      if (paramInt != 0) {
        bool2 = true;
      }
      return new ayth(paramViewGroup, bool2, bool1);
      return new aytj(paramViewGroup, 2131559502);
      return new ayte(paramViewGroup);
      return new aytg(paramViewGroup, 2131562594, 2130845548, -1);
      return new aytg(paramViewGroup, 2131562594, 2130845548, 12);
      return new aytk(paramViewGroup, 2131559697);
      return new ayrm(paramViewGroup, 2131562578);
      return new ayrw(paramViewGroup, 2131562580);
      return new ayry(paramViewGroup, 2131562581);
      return new ayrl(paramViewGroup, 2131562623);
      return new aytj(paramViewGroup, 2131562575);
      return new aytj(paramViewGroup, 2131562582);
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = a(paramInt);
      localObject2 = ayop.a().a((QQAppInterface)localObject2, paramViewGroup.getContext(), (ayjj)localObject1);
      if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof aykr))) {
        ((aykr)localObject1).c(((ayof)localObject2).b());
      }
      if (localObject2 == null) {
        return new ayrp(paramViewGroup);
      }
      return ((ayof)localObject2).a();
      return new aytc(paramViewGroup, a(paramInt));
      localObject1 = a(paramInt);
      if ((localObject1 instanceof ayku)) {
        return new aytb(paramViewGroup, ((ayku)localObject1).d());
      }
      throw new RuntimeException("model type is TYPE_UNITE_ENTRANCE_SUB_ITEM_COMMON_TEXT, but model item is not instance SearchResultModelForEntrance.");
      localObject1 = a(paramInt);
      if ((localObject1 instanceof ayju))
      {
        localObject1 = (ayju)localObject1;
        switch (((ayju)localObject1).d())
        {
        case 5: 
        case 10: 
        default: 
          throw new RuntimeException("NetSearchTemplateBaseItem.getLayoutId() is " + ((ayju)localObject1).e() + " which is not supported!!!");
        case 2: 
          return new ayrz(paramViewGroup, ((ayju)localObject1).e());
        case 3: 
          return new aysv(paramViewGroup, ((ayju)localObject1).e());
        case 4: 
          return new aysa(paramViewGroup, ((ayju)localObject1).e());
        case 7: 
          return new aysh(paramViewGroup, ((ayju)localObject1).e());
        case 6: 
          return new aysu(paramViewGroup, ((ayju)localObject1).e());
        case 8: 
          return new ayss(paramViewGroup, ((ayju)localObject1).e());
        case 9: 
          return new aysr(paramViewGroup, ((ayju)localObject1).e());
        case 11: 
          return new ayse(paramViewGroup, ((ayju)localObject1).e());
        case 12: 
          return new aysc(paramViewGroup, ((ayju)localObject1).e());
        case 13: 
          return new aysf(paramViewGroup, ((ayju)localObject1).e());
        case 14: 
          return new ayst(paramViewGroup, ((ayju)localObject1).e());
        case 15: 
          return new aysp(paramViewGroup, ((ayju)localObject1).e());
        case 16: 
          return new aysk(paramViewGroup, ((ayju)localObject1).e());
        case 17: 
          return new aysm(paramViewGroup, ((ayju)localObject1).e());
        }
        return new aysj(paramViewGroup, ((ayju)localObject1).e());
      }
      throw new RuntimeException("model type is TYPE_UNITE_TEMPLATE_NORMAL or TYPE_UNITE_TEMPLATE_NEWS, but model item is not instance NetSearchTemplateBaseItem.");
      return new aytk(paramViewGroup, 2131559503);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 12;
    if ((super.a(paramInt) instanceof ayiu)) {
      i = 41;
    }
    do
    {
      return i;
      if ((super.a(paramInt) instanceof ayiy)) {
        return 3;
      }
    } while ((super.a(paramInt) instanceof ayhd));
    if (((super.a(paramInt) instanceof ayis)) && (this.b != 12))
    {
      if (((ayis)super.a(paramInt)).jdField_a_of_type_Boolean) {
        return 0;
      }
      return 57;
    }
    if (((super.a(paramInt) instanceof ayis)) && (this.b == 12))
    {
      if (((ayis)super.a(paramInt)).jdField_a_of_type_Boolean) {
        return 15;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof ayit))
    {
      ayit localayit = (ayit)super.a(paramInt);
      if ((localayit != null) && (localayit.jdField_a_of_type_Boolean)) {
        return 49;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof ayjd)) {
      return 2;
    }
    if ((super.a(paramInt) instanceof ayim)) {
      return 5;
    }
    if ((super.a(paramInt) instanceof ayiz)) {
      return 56;
    }
    if ((super.a(paramInt) instanceof ayiq)) {
      return 6;
    }
    if ((super.a(paramInt) instanceof ayjb)) {
      return 60;
    }
    if ((super.a(paramInt) instanceof ayio)) {
      return 8;
    }
    if ((super.a(paramInt) instanceof ayik)) {
      return 16;
    }
    if (((super.a(paramInt) instanceof ayja)) && (this.b != 12)) {
      return 9;
    }
    if (((super.a(paramInt) instanceof ayja)) && (this.b == 12)) {
      return 14;
    }
    if ((a(paramInt) instanceof biru)) {
      return 10;
    }
    if ((a(paramInt) instanceof aqyn)) {
      return 11;
    }
    if (((super.a(paramInt) instanceof ayiv)) || ((super.a(paramInt) instanceof ayix))) {
      return 13;
    }
    if ((a(paramInt) instanceof ayjc)) {
      return 17;
    }
    if ((a(paramInt) instanceof ayiw)) {
      return 19;
    }
    if ((a(paramInt) instanceof aykr)) {
      return 59;
    }
    if ((a(paramInt) instanceof ayij))
    {
      switch (((ayij)a(paramInt)).d())
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
    if ((a(paramInt) instanceof ayku))
    {
      switch (((ayku)a(paramInt)).jdField_a_of_type_Int)
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
    if ((a(paramInt) instanceof ayju))
    {
      switch (((ayju)a(paramInt)).d())
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
    if ((a(paramInt) instanceof aykp)) {
      return 46;
    }
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ayjj localayjj = a(paramInt);
    Object localObject3;
    int j;
    Object localObject6;
    Object localObject7;
    Object localObject2;
    if (aydw.a(localayjj) > 0)
    {
      Object localObject1;
      if (aydw.b.containsKey(localayjj))
      {
        localObject1 = (aydx)aydw.b.get(localayjj);
        if (!((aydx)localObject1).jdField_a_of_type_Boolean)
        {
          ((aydx)localObject1).jdField_a_of_type_Boolean = true;
          localObject3 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject3).put("project", aynt.a());
        ((JSONObject)localObject3).put("event_src", "client");
        ((JSONObject)localObject3).put("get_src", "native");
        ((JSONObject)localObject3).put("obj_lct", ((aydx)localObject1).jdField_a_of_type_Int);
        localObject4 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        aynt.a((QQAppInterface)localObject4, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((aydx)localObject1).jdField_a_of_type_Long + "").obj2(((aydx)localObject1).jdField_b_of_type_JavaLangString).ver1(((aydx)localObject1).jdField_a_of_type_JavaLangString).ver2(aynt.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject4).getCurrentAccountUin() + aydw.jdField_a_of_type_Long));
        ((aydx)localObject1).jdField_a_of_type_Boolean = true;
        aydw.b.put(localayjj, localObject1);
        if ((localayjj instanceof ayjk))
        {
          localObject1 = (ayjk)localayjj;
          localObject3 = ((ayjk)localObject1).a();
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            j = Math.min(((List)localObject3).size(), ((ayjk)localObject1).a());
            i = 0;
            if (i < j) {
              if (aydw.b.containsKey(((List)localObject3).get(i)))
              {
                localObject4 = (aydx)aydw.b.get(((List)localObject3).get(i));
                if (!((aydx)localObject4).jdField_a_of_type_Boolean)
                {
                  ((aydx)localObject4).jdField_a_of_type_Boolean = true;
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
            ((JSONObject)localObject6).put("project", aynt.a());
            ((JSONObject)localObject6).put("event_src", "client");
            ((JSONObject)localObject6).put("get_src", "native");
            ((JSONObject)localObject6).put("obj_lct", ((aydx)localObject4).jdField_a_of_type_Int);
            if (!(((List)localObject3).get(i) instanceof ayjq)) {
              break label716;
            }
            localObject7 = (ayjq)((List)localObject3).get(i);
            if (!((ayjq)localObject7).c()) {
              break;
            }
            localObject1 = "1";
            ((aydx)localObject4).jdField_b_of_type_JavaLangString = ((ayjq)localObject7).e();
            localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            aynt.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((aydx)localObject4).jdField_a_of_type_Long + "").obj2(((aydx)localObject4).jdField_b_of_type_JavaLangString).ver1(((aydx)localObject4).jdField_a_of_type_JavaLangString).ver2(aynt.a(this.b)).ver3((String)localObject1).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + aydw.jdField_a_of_type_Long));
            ((aydx)localObject4).jdField_a_of_type_Boolean = true;
            aydw.b.put(((List)localObject3).get(i), localObject4);
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
            aynt.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localJSONException2.jdField_a_of_type_Long + "").obj2(localJSONException2.jdField_b_of_type_JavaLangString).ver1(localJSONException2.jdField_a_of_type_JavaLangString).ver2(aynt.a(this.b)).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + aydw.jdField_a_of_type_Long));
            localJSONException2.jdField_a_of_type_Boolean = true;
            aydw.b.put(((List)localObject3).get(i), localJSONException2);
          }
        }
      }
    }
    Object localObject5;
    if ((localayjj instanceof ayii))
    {
      localObject2 = (ayii)localayjj;
      if ((((ayii)localObject2).a() != null) && (((ayii)localObject2).a().size() > 0))
      {
        i = 0;
        for (;;)
        {
          if (i >= ((ayii)localObject2).a().size()) {
            break label1809;
          }
          localObject3 = (ayjj)((ayii)localObject2).a().get(i);
          if (aydw.b.containsKey(localObject3))
          {
            localObject3 = (aydx)aydw.b.get(localObject3);
            if (!((aydx)localObject3).jdField_a_of_type_Boolean)
            {
              ((aydx)localObject3).jdField_a_of_type_Boolean = true;
              localObject5 = new JSONObject();
            }
          }
          try
          {
            ((JSONObject)localObject5).put("project", aynt.a());
            ((JSONObject)localObject5).put("event_src", "client");
            ((JSONObject)localObject5).put("get_src", "web");
            ((JSONObject)localObject5).put("obj_lct", ((aydx)localObject3).jdField_a_of_type_Int);
            localObject6 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            aynt.a((QQAppInterface)localObject6, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((aydx)localObject3).jdField_a_of_type_Long + "").obj2(((aydx)localObject3).jdField_b_of_type_JavaLangString).ver1(((aydx)localObject3).jdField_a_of_type_JavaLangString).ver2(aynt.a(this.b)).ver7(((JSONObject)localObject5).toString()).session_id(((QQAppInterface)localObject6).getCurrentAccountUin() + aydw.jdField_a_of_type_Long));
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
    else if ((localayjj instanceof aykb))
    {
      localObject2 = ((aykb)localayjj).a;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1809;
          }
          localObject3 = (ayka)((Iterator)localObject2).next();
          if (aydw.b.containsKey(localObject3))
          {
            localObject5 = (aydx)aydw.b.get(localObject3);
            if (!((aydx)localObject5).jdField_a_of_type_Boolean)
            {
              ((aydx)localObject5).jdField_a_of_type_Boolean = true;
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("project", aynt.a());
                localJSONObject.put("event_src", "client");
                localJSONObject.put("get_src", "web");
                localJSONObject.put("obj_lct", ((aydx)localObject5).jdField_a_of_type_Int);
                localJSONObject.put("extra_info", ((ayka)localObject3).jdField_b_of_type_JavaLangString);
                localJSONObject.put("tepl", ((ayka)localObject3).f);
                localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                aynt.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((ayka)localObject3).jdField_a_of_type_Long + "").obj2(((ayka)localObject3).j).ver1(((aydx)localObject5).jdField_a_of_type_JavaLangString).ver2(aynt.a(this.b)).ver7(localJSONObject.toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + aydw.jdField_a_of_type_Long));
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
      if (!(localayjj instanceof ayke)) {
        break label2257;
      }
      if (aydw.b.containsKey(localayjj))
      {
        localObject2 = (aydx)aydw.b.get(localayjj);
        localObject3 = (ayke)localayjj;
        if (!((aydx)localObject2).jdField_a_of_type_Boolean)
        {
          ((aydx)localObject2).jdField_a_of_type_Boolean = true;
          localObject5 = new StringBuilder();
          if ((((ayke)localObject3).a != null) && (((ayke)localObject3).a.size() > 0))
          {
            i = 0;
            if (i < ((ayke)localObject3).a.size())
            {
              if (i != ((ayke)localObject3).a.size() - 1) {
                ((StringBuilder)localObject5).append(((ayjr)((ayke)localObject3).a.get(i)).jdField_b_of_type_JavaLangString).append("::");
              }
              for (;;)
              {
                i += 1;
                break;
                ((StringBuilder)localObject5).append(((ayjr)((ayke)localObject3).a.get(i)).jdField_b_of_type_JavaLangString);
              }
            }
          }
          aynt.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((aydx)localObject2).jdField_a_of_type_JavaLangString).ver2(aynt.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + aynt.jdField_b_of_type_JavaLangString + "}"));
        }
      }
    }
    label1809:
    if (aydw.jdField_a_of_type_JavaUtilHashMap.containsKey(localayjj))
    {
      localObject2 = (aydx)aydw.jdField_a_of_type_JavaUtilHashMap.get(localayjj);
      if (!((aydx)localObject2).jdField_a_of_type_Boolean)
      {
        if (ayrd.a(((aydx)localObject2).jdField_a_of_type_Long))
        {
          if (!((aydx)localObject2).jdField_b_of_type_Boolean) {
            break label2874;
          }
          i = 2;
          label1863:
          ayrd.a("all_result", "exp_object", i, 0, new String[] { ((aydx)localObject2).jdField_a_of_type_JavaLangString, ((aydx)localObject2).jdField_a_of_type_Long + "", ((aydx)localObject2).jdField_b_of_type_JavaLangString, ((aydx)localObject2).jdField_a_of_type_Int + "" });
          ((aydx)localObject2).jdField_a_of_type_Boolean = true;
          aydw.jdField_a_of_type_JavaUtilHashMap.put((ayjl)localayjj, localObject2);
        }
        if ((localayjj instanceof ayku))
        {
          localObject3 = (ayku)localayjj;
          if ((((ayku)localObject3).jdField_a_of_type_Int == -3) || (((ayku)localObject3).jdField_a_of_type_Int == -4)) {
            if (!((aydx)localObject2).jdField_b_of_type_Boolean) {
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
        ayrd.a("all_result", "exp_net_search", i, 0, new String[] { ((aydx)localObject2).jdField_a_of_type_JavaLangString, ((aydx)localObject2).jdField_a_of_type_Long + "", ((aydx)localObject2).jdField_b_of_type_JavaLangString, ((aydx)localObject2).jdField_a_of_type_Int + "" });
        localObject2 = paramView;
        if (!a(paramView, localayjj)) {
          localObject2 = null;
        }
        paramView = super.getView(paramInt, (View)localObject2, paramViewGroup);
        a(paramInt, paramView, localayjj);
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
          bool2 = a(paramView, localayjj, paramInt, i, j, bool2);
        }
        if ((paramView != null) && (paramView.findViewById(2131365367) != null))
        {
          if (!bool2) {
            break label2886;
          }
          paramView.findViewById(2131365367).setVisibility(8);
        }
        return paramView;
        label2257:
        if (((!(localayjj instanceof ayju)) || ((localayjj instanceof ayki))) && (((!(localayjj instanceof ayij)) && ((!(localayjj instanceof ayku)) || (((ayku)localayjj).jdField_a_of_type_Int != -4))) || (!aydw.b.containsKey(localayjj)))) {
          break;
        }
        localObject2 = (aydx)aydw.b.get(localayjj);
        if ((localayjj instanceof aykf))
        {
          localObject3 = (aykf)localayjj;
          if (!((aydx)localObject2).jdField_a_of_type_Boolean)
          {
            ((aydx)localObject2).jdField_a_of_type_Boolean = true;
            localObject5 = new StringBuilder();
            if ((((aykf)localObject3).a != null) && (((aykf)localObject3).a.size() > 0))
            {
              i = 0;
              while (i < ((aykf)localObject3).a.size())
              {
                ((StringBuilder)localObject5).append(((aykq)((aykf)localObject3).a.get(i)).jdField_a_of_type_JavaLangString).append("::");
                i += 1;
              }
              aynt.a(null, new ReportModelDC02528().module("all_result").action("exp_relatedsearch_list").obj1("1007").ver1(((aydx)localObject2).jdField_a_of_type_JavaLangString).ver2(aynt.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + aynt.jdField_b_of_type_JavaLangString + "}"));
            }
            aynt.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((aydx)localObject2).jdField_a_of_type_JavaLangString).ver2(aynt.a(this.b)).ver5("2").ver7("{experiment_id:" + aynt.jdField_b_of_type_JavaLangString + "}"));
          }
        }
        if (((aydx)localObject2).jdField_a_of_type_Boolean) {
          break;
        }
        ((aydx)localObject2).jdField_a_of_type_Boolean = true;
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("project", aynt.a());
          ((JSONObject)localObject3).put("event_src", "client");
          ((JSONObject)localObject3).put("get_src", "web");
          ((JSONObject)localObject3).put("obj_lct", ((aydx)localObject2).jdField_a_of_type_Int);
          if ((localayjj instanceof ayju)) {
            ((JSONObject)localObject3).put("tepl", ((ayju)localayjj).f);
          }
          localObject5 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          aynt.a((QQAppInterface)localObject5, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((aydx)localObject2).jdField_a_of_type_Long + "").obj2(((aydx)localObject2).jdField_b_of_type_JavaLangString).ver1(((aydx)localObject2).jdField_a_of_type_JavaLangString).ver2(aynt.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject5).getCurrentAccountUin() + aydw.jdField_a_of_type_Long));
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
    paramView.findViewById(2131365367).setVisibility(0);
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
      if ((localObject instanceof ayis))
      {
        localObject = (ayis)localObject;
        k = i + 1;
        ((ayis)localObject).a(1, k);
        i = j;
        if (((ayis)localObject).b() == 2) {
          i = j + 1;
        }
        ((ayis)localObject).a(3, i);
        ((ayis)localObject).a(0, k, i);
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
        if ((localObject instanceof aykt))
        {
          localObject = (aykt)localObject;
          k += 1;
          ((aykt)localObject).a(k, i, j);
          m = i;
          i = k;
          k = j;
          j = m;
        }
        else
        {
          m = k;
          if ((localObject instanceof ayij))
          {
            localObject = (ayij)localObject;
            m = k + 1;
            ((ayij)localObject).a(m, i, j);
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
      QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "onDecodeTaskCompleted, remainingTasks : " + paramInt1 + ", type : " + paramInt2 + ", uin : " + paramString + ", avatar : " + paramBitmap + ", mFaceDecoder.isPausing() : " + this.jdField_a_of_type_Bcws.a() + ", mScrollState : " + this.jdField_a_of_type_Int);
    }
    if ((!this.jdField_a_of_type_Bcws.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1);
        ayji localayji;
        aymf localaymf;
        ayrs localayrs;
        if (((localView.getTag(2131379913) instanceof ayji)) && ((localView.getTag(2131379915) instanceof aymf)) && ((localView.getTag(2131379918) instanceof ayrs)))
        {
          localayji = (ayji)localView.getTag(2131379913);
          localaymf = (aymf)localView.getTag(2131379915);
          localayrs = (ayrs)localView.getTag(2131379918);
          if ((localayji.c() == paramInt2) && (paramString.equals(localayji.b()))) {
            localaymf.a(localayji, localayrs, paramBitmap);
          }
        }
        if ((localView instanceof ViewGroup))
        {
          int i = 0;
          while (i < ((ViewGroup)localView).getChildCount())
          {
            localayji = (ayji)((ViewGroup)localView).getChildAt(i).getTag(2131379913);
            if ((localayji != null) && (localayji.c() == paramInt2) && (paramString.equals(localayji.b())))
            {
              localaymf = (aymf)((ViewGroup)localView).getChildAt(i).getTag(2131379915);
              localayrs = (ayrs)((ViewGroup)localView).getChildAt(i).getTag(2131379918);
              if ((localaymf != null) && (localayrs != null)) {
                localaymf.a(localayji, localayrs, paramBitmap);
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
    if (this.jdField_a_of_type_Bhpo != null) {
      this.jdField_a_of_type_Bhpo.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    this.jdField_a_of_type_Ayon.a(paramInt1, paramInt2, paramInt3);
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
      if (this.jdField_a_of_type_Bcws.a()) {
        this.jdField_a_of_type_Bcws.b();
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
          ayji localayji = (ayji)((ViewGroup)localView).getChildAt(j).getTag(2131379913);
          aymf localaymf = (aymf)((ViewGroup)localView).getChildAt(j).getTag(2131379915);
          ayrs localayrs = (ayrs)((ViewGroup)localView).getChildAt(j).getTag(2131379918);
          if ((localaymf != null) && (localayji != null) && (paramAbsListView != null)) {
            localaymf.a(localayji, localayrs);
          }
          j += 1;
        }
      }
      i += 1;
      continue;
      this.jdField_a_of_type_Bcws.a();
      this.jdField_a_of_type_Bcws.c();
    }
    if (this.jdField_a_of_type_Bhpo != null) {
      this.jdField_a_of_type_Bhpo.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.jdField_a_of_type_Ayon.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfh
 * JD-Core Version:    0.7.0.1
 */