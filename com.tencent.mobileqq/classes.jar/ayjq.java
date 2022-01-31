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

public class ayjq
  extends ayjn
  implements bdbc, bhtv
{
  protected int a;
  private aysw jdField_a_of_type_Aysw = new aysw();
  private bdbb jdField_a_of_type_Bdbb;
  private bhtv jdField_a_of_type_Bhtv;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  public int b = -1;
  
  public ayjq(ListView paramListView, bdbb parambdbb, bhtv parambhtv, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Bdbb = parambdbb;
    parambdbb.a(this);
    paramListView.setOnScrollListener(this);
    this.jdField_a_of_type_Bhtv = parambhtv;
    this.b = paramInt;
  }
  
  private ayso a(int paramInt)
  {
    ayns localayns = a(paramInt);
    if (localayns == null) {
      return null;
    }
    if (!(localayns instanceof ayso)) {
      return null;
    }
    return (ayso)localayns;
  }
  
  private void a(int paramInt, View paramView, ayns paramayns)
  {
    if ((paramView == null) || (paramayns == null)) {}
    for (;;)
    {
      return;
      if ((paramayns instanceof aypa))
      {
        paramView = (aywe)paramView.getTag(2131379976);
        if ((paramView instanceof aysq)) {}
        for (paramView = ((aysq)paramView).a(); paramView != null; paramView = null)
        {
          this.jdField_a_of_type_Aysw.a(paramInt, paramView);
          return;
        }
      }
    }
  }
  
  private boolean a(View paramView, ayns paramayns)
  {
    if ((paramView == null) || (paramayns == null)) {
      return false;
    }
    if ((paramayns instanceof aypa))
    {
      aywe localaywe = (aywe)paramView.getTag(2131379976);
      paramView = null;
      if ((localaywe instanceof aysq)) {
        paramView = ((aysq)localaywe).a();
      }
      if (paramView == null) {
        return false;
      }
      if ((((aypa)paramayns).f() != paramView.c()) || (((aypa)paramayns).h() != paramView.b())) {
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
  
  private boolean a(View paramView, ayns paramayns, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt2 == 59)
    {
      if (paramView == null) {
        break label203;
      }
      paramView = (aywe)paramView.getTag(2131379976);
      if (!(paramView instanceof aysq)) {
        break label71;
      }
      paramView = (aysq)paramView;
    }
    for (;;)
    {
      if ((paramView != null) && ((paramView instanceof ayta)))
      {
        if (paramInt1 != 0) {
          break label76;
        }
        ((ayta)paramView).a(false);
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
            if ((!(localObject instanceof aynb)) || (((aynb)localObject).jdField_a_of_type_Boolean)) {
              break label197;
            }
          }
        }
      }
      label167:
      label197:
      for (Object localObject = ((aynb)localObject).a().a();; localObject = null)
      {
        if ((paramayns != null) && (localObject != null) && (((List)localObject).contains(paramayns))) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 == 0) {
            break label167;
          }
          ((ayta)paramView).a(false);
          break;
        }
        break;
        paramView = a(paramInt1 - 1);
        if ((!(paramView instanceof aysm)) || (((aysm)paramView).a() != 1)) {
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
    if ((a(paramInt) instanceof aymr)) {
      return ((aymr)a(paramInt)).b();
    }
    if ((a(paramInt) instanceof ayms)) {
      return ((ayms)a(paramInt)).d();
    }
    return 0;
  }
  
  protected ayqp a(int paramInt)
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
      return new ayrj(this.jdField_a_of_type_Bdbb);
    case 41: 
      return new ayqn(this.jdField_a_of_type_Bdbb);
    case 3: 
      return new ayrf(this.jdField_a_of_type_Bdbb, false);
    case 12: 
      return new ayrf(this.jdField_a_of_type_Bdbb, true);
    case 57: 
      return new ayqj();
    case 0: 
      return new ayrk();
    case 49: 
      return new ayrd();
    case 15: 
      return new ayrk();
    case 2: 
    case 8: 
      return new ayqy(this.jdField_a_of_type_Bdbb);
    case 9: 
      return new ayrh();
    case 14: 
      return new ayrh();
    case 10: 
      return new bivx();
    case 11: 
      return new arct(this.jdField_a_of_type_Bdbb);
    case 13: 
      return new ayqa(this.jdField_a_of_type_Bdbb);
    case 56: 
      return new ayqq(this.jdField_a_of_type_Bdbb);
    case 60: 
      return new ayqu(this.jdField_a_of_type_Bdbb);
    case 16: 
      return new ayrj(this.jdField_a_of_type_Bdbb);
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 31: 
    case 40: 
      return new aypv(this.jdField_a_of_type_Bdbb, a(paramInt), this);
    case 29: 
    case 30: 
    case 36: 
      return new ayqk();
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
      return new ayro(this.jdField_a_of_type_Bdbb, this);
    case 46: 
      return new ayqz(this.jdField_a_of_type_Bdbb);
    }
    return new ayra(this.jdField_a_of_type_Bdbb, this);
  }
  
  protected aywe a(int paramInt, ViewGroup paramViewGroup)
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
      return new ayxs(paramViewGroup, 2131562592);
    case 41: 
      return new aywa(paramViewGroup);
    case 3: 
      return new ayxo(paramViewGroup);
    case 12: 
      return new ayxm(paramViewGroup);
    case 57: 
      return new ayvy(paramViewGroup);
    case 0: 
    case 15: 
      localObject1 = a(paramInt);
      if (!(localObject1 instanceof aynb)) {
        break;
      }
    }
    for (boolean bool1 = ((aynb)localObject1).a();; bool1 = false)
    {
      if (paramInt != 0) {
        bool2 = true;
      }
      return new ayxq(paramViewGroup, bool2, bool1);
      return new ayxs(paramViewGroup, 2131559501);
      return new ayxn(paramViewGroup);
      return new ayxp(paramViewGroup, 2131562612, 2130845620, -1);
      return new ayxp(paramViewGroup, 2131562612, 2130845620, 12);
      return new ayxt(paramViewGroup, 2131559696);
      return new ayvv(paramViewGroup, 2131562596);
      return new aywf(paramViewGroup, 2131562598);
      return new aywh(paramViewGroup, 2131562599);
      return new ayvu(paramViewGroup, 2131562641);
      return new ayxs(paramViewGroup, 2131562593);
      return new ayxs(paramViewGroup, 2131562600);
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = a(paramInt);
      localObject2 = aysy.a().a((QQAppInterface)localObject2, paramViewGroup.getContext(), (ayns)localObject1);
      if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof aypa))) {
        ((aypa)localObject1).c(((ayso)localObject2).b());
      }
      if (localObject2 == null) {
        return new ayvy(paramViewGroup);
      }
      return ((ayso)localObject2).a();
      return new ayxl(paramViewGroup, a(paramInt));
      localObject1 = a(paramInt);
      if ((localObject1 instanceof aypd)) {
        return new ayxk(paramViewGroup, ((aypd)localObject1).d());
      }
      throw new RuntimeException("model type is TYPE_UNITE_ENTRANCE_SUB_ITEM_COMMON_TEXT, but model item is not instance SearchResultModelForEntrance.");
      localObject1 = a(paramInt);
      if ((localObject1 instanceof ayod))
      {
        localObject1 = (ayod)localObject1;
        switch (((ayod)localObject1).d())
        {
        case 5: 
        case 10: 
        default: 
          throw new RuntimeException("NetSearchTemplateBaseItem.getLayoutId() is " + ((ayod)localObject1).e() + " which is not supported!!!");
        case 2: 
          return new aywi(paramViewGroup, ((ayod)localObject1).e());
        case 3: 
          return new ayxe(paramViewGroup, ((ayod)localObject1).e());
        case 4: 
          return new aywj(paramViewGroup, ((ayod)localObject1).e());
        case 7: 
          return new aywq(paramViewGroup, ((ayod)localObject1).e());
        case 6: 
          return new ayxd(paramViewGroup, ((ayod)localObject1).e());
        case 8: 
          return new ayxb(paramViewGroup, ((ayod)localObject1).e());
        case 9: 
          return new ayxa(paramViewGroup, ((ayod)localObject1).e());
        case 11: 
          return new aywn(paramViewGroup, ((ayod)localObject1).e());
        case 12: 
          return new aywl(paramViewGroup, ((ayod)localObject1).e());
        case 13: 
          return new aywo(paramViewGroup, ((ayod)localObject1).e());
        case 14: 
          return new ayxc(paramViewGroup, ((ayod)localObject1).e());
        case 15: 
          return new aywy(paramViewGroup, ((ayod)localObject1).e());
        case 16: 
          return new aywt(paramViewGroup, ((ayod)localObject1).e());
        case 17: 
          return new aywv(paramViewGroup, ((ayod)localObject1).e());
        }
        return new ayws(paramViewGroup, ((ayod)localObject1).e());
      }
      throw new RuntimeException("model type is TYPE_UNITE_TEMPLATE_NORMAL or TYPE_UNITE_TEMPLATE_NEWS, but model item is not instance NetSearchTemplateBaseItem.");
      return new ayxt(paramViewGroup, 2131559502);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 12;
    if ((super.a(paramInt) instanceof aynd)) {
      i = 41;
    }
    do
    {
      return i;
      if ((super.a(paramInt) instanceof aynh)) {
        return 3;
      }
    } while ((super.a(paramInt) instanceof aylm));
    if (((super.a(paramInt) instanceof aynb)) && (this.b != 12))
    {
      if (((aynb)super.a(paramInt)).jdField_a_of_type_Boolean) {
        return 0;
      }
      return 57;
    }
    if (((super.a(paramInt) instanceof aynb)) && (this.b == 12))
    {
      if (((aynb)super.a(paramInt)).jdField_a_of_type_Boolean) {
        return 15;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof aync))
    {
      aync localaync = (aync)super.a(paramInt);
      if ((localaync != null) && (localaync.jdField_a_of_type_Boolean)) {
        return 49;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof aynm)) {
      return 2;
    }
    if ((super.a(paramInt) instanceof aymv)) {
      return 5;
    }
    if ((super.a(paramInt) instanceof ayni)) {
      return 56;
    }
    if ((super.a(paramInt) instanceof aymz)) {
      return 6;
    }
    if ((super.a(paramInt) instanceof aynk)) {
      return 60;
    }
    if ((super.a(paramInt) instanceof aymx)) {
      return 8;
    }
    if ((super.a(paramInt) instanceof aymt)) {
      return 16;
    }
    if (((super.a(paramInt) instanceof aynj)) && (this.b != 12)) {
      return 9;
    }
    if (((super.a(paramInt) instanceof aynj)) && (this.b == 12)) {
      return 14;
    }
    if ((a(paramInt) instanceof biwb)) {
      return 10;
    }
    if ((a(paramInt) instanceof arcw)) {
      return 11;
    }
    if (((super.a(paramInt) instanceof ayne)) || ((super.a(paramInt) instanceof ayng))) {
      return 13;
    }
    if ((a(paramInt) instanceof aynl)) {
      return 17;
    }
    if ((a(paramInt) instanceof aynf)) {
      return 19;
    }
    if ((a(paramInt) instanceof aypa)) {
      return 59;
    }
    if ((a(paramInt) instanceof ayms))
    {
      switch (((ayms)a(paramInt)).d())
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
    if ((a(paramInt) instanceof aypd))
    {
      switch (((aypd)a(paramInt)).jdField_a_of_type_Int)
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
    if ((a(paramInt) instanceof ayod))
    {
      switch (((ayod)a(paramInt)).d())
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
    if ((a(paramInt) instanceof ayoy)) {
      return 46;
    }
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ayns localayns = a(paramInt);
    Object localObject3;
    int j;
    Object localObject6;
    Object localObject7;
    Object localObject2;
    if (ayif.a(localayns) > 0)
    {
      Object localObject1;
      if (ayif.b.containsKey(localayns))
      {
        localObject1 = (ayig)ayif.b.get(localayns);
        if (!((ayig)localObject1).jdField_a_of_type_Boolean)
        {
          ((ayig)localObject1).jdField_a_of_type_Boolean = true;
          localObject3 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject3).put("project", aysc.a());
        ((JSONObject)localObject3).put("event_src", "client");
        ((JSONObject)localObject3).put("get_src", "native");
        ((JSONObject)localObject3).put("obj_lct", ((ayig)localObject1).jdField_a_of_type_Int);
        localObject4 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        aysc.a((QQAppInterface)localObject4, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((ayig)localObject1).jdField_a_of_type_Long + "").obj2(((ayig)localObject1).jdField_b_of_type_JavaLangString).ver1(((ayig)localObject1).jdField_a_of_type_JavaLangString).ver2(aysc.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject4).getCurrentAccountUin() + ayif.jdField_a_of_type_Long));
        ((ayig)localObject1).jdField_a_of_type_Boolean = true;
        ayif.b.put(localayns, localObject1);
        if ((localayns instanceof aynt))
        {
          localObject1 = (aynt)localayns;
          localObject3 = ((aynt)localObject1).a();
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            j = Math.min(((List)localObject3).size(), ((aynt)localObject1).a());
            i = 0;
            if (i < j) {
              if (ayif.b.containsKey(((List)localObject3).get(i)))
              {
                localObject4 = (ayig)ayif.b.get(((List)localObject3).get(i));
                if (!((ayig)localObject4).jdField_a_of_type_Boolean)
                {
                  ((ayig)localObject4).jdField_a_of_type_Boolean = true;
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
            ((JSONObject)localObject6).put("project", aysc.a());
            ((JSONObject)localObject6).put("event_src", "client");
            ((JSONObject)localObject6).put("get_src", "native");
            ((JSONObject)localObject6).put("obj_lct", ((ayig)localObject4).jdField_a_of_type_Int);
            if (!(((List)localObject3).get(i) instanceof aynz)) {
              break label716;
            }
            localObject7 = (aynz)((List)localObject3).get(i);
            if (!((aynz)localObject7).c()) {
              break;
            }
            localObject1 = "1";
            ((ayig)localObject4).jdField_b_of_type_JavaLangString = ((aynz)localObject7).e();
            localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            aysc.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((ayig)localObject4).jdField_a_of_type_Long + "").obj2(((ayig)localObject4).jdField_b_of_type_JavaLangString).ver1(((ayig)localObject4).jdField_a_of_type_JavaLangString).ver2(aysc.a(this.b)).ver3((String)localObject1).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + ayif.jdField_a_of_type_Long));
            ((ayig)localObject4).jdField_a_of_type_Boolean = true;
            ayif.b.put(((List)localObject3).get(i), localObject4);
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
            aysc.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localJSONException2.jdField_a_of_type_Long + "").obj2(localJSONException2.jdField_b_of_type_JavaLangString).ver1(localJSONException2.jdField_a_of_type_JavaLangString).ver2(aysc.a(this.b)).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + ayif.jdField_a_of_type_Long));
            localJSONException2.jdField_a_of_type_Boolean = true;
            ayif.b.put(((List)localObject3).get(i), localJSONException2);
          }
        }
      }
    }
    Object localObject5;
    if ((localayns instanceof aymr))
    {
      localObject2 = (aymr)localayns;
      if ((((aymr)localObject2).a() != null) && (((aymr)localObject2).a().size() > 0))
      {
        i = 0;
        for (;;)
        {
          if (i >= ((aymr)localObject2).a().size()) {
            break label1809;
          }
          localObject3 = (ayns)((aymr)localObject2).a().get(i);
          if (ayif.b.containsKey(localObject3))
          {
            localObject3 = (ayig)ayif.b.get(localObject3);
            if (!((ayig)localObject3).jdField_a_of_type_Boolean)
            {
              ((ayig)localObject3).jdField_a_of_type_Boolean = true;
              localObject5 = new JSONObject();
            }
          }
          try
          {
            ((JSONObject)localObject5).put("project", aysc.a());
            ((JSONObject)localObject5).put("event_src", "client");
            ((JSONObject)localObject5).put("get_src", "web");
            ((JSONObject)localObject5).put("obj_lct", ((ayig)localObject3).jdField_a_of_type_Int);
            localObject6 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            aysc.a((QQAppInterface)localObject6, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((ayig)localObject3).jdField_a_of_type_Long + "").obj2(((ayig)localObject3).jdField_b_of_type_JavaLangString).ver1(((ayig)localObject3).jdField_a_of_type_JavaLangString).ver2(aysc.a(this.b)).ver7(((JSONObject)localObject5).toString()).session_id(((QQAppInterface)localObject6).getCurrentAccountUin() + ayif.jdField_a_of_type_Long));
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
    else if ((localayns instanceof ayok))
    {
      localObject2 = ((ayok)localayns).a;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1809;
          }
          localObject3 = (ayoj)((Iterator)localObject2).next();
          if (ayif.b.containsKey(localObject3))
          {
            localObject5 = (ayig)ayif.b.get(localObject3);
            if (!((ayig)localObject5).jdField_a_of_type_Boolean)
            {
              ((ayig)localObject5).jdField_a_of_type_Boolean = true;
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("project", aysc.a());
                localJSONObject.put("event_src", "client");
                localJSONObject.put("get_src", "web");
                localJSONObject.put("obj_lct", ((ayig)localObject5).jdField_a_of_type_Int);
                localJSONObject.put("extra_info", ((ayoj)localObject3).jdField_b_of_type_JavaLangString);
                localJSONObject.put("tepl", ((ayoj)localObject3).f);
                localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                aysc.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((ayoj)localObject3).jdField_a_of_type_Long + "").obj2(((ayoj)localObject3).j).ver1(((ayig)localObject5).jdField_a_of_type_JavaLangString).ver2(aysc.a(this.b)).ver7(localJSONObject.toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + ayif.jdField_a_of_type_Long));
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
      if (!(localayns instanceof ayon)) {
        break label2257;
      }
      if (ayif.b.containsKey(localayns))
      {
        localObject2 = (ayig)ayif.b.get(localayns);
        localObject3 = (ayon)localayns;
        if (!((ayig)localObject2).jdField_a_of_type_Boolean)
        {
          ((ayig)localObject2).jdField_a_of_type_Boolean = true;
          localObject5 = new StringBuilder();
          if ((((ayon)localObject3).a != null) && (((ayon)localObject3).a.size() > 0))
          {
            i = 0;
            if (i < ((ayon)localObject3).a.size())
            {
              if (i != ((ayon)localObject3).a.size() - 1) {
                ((StringBuilder)localObject5).append(((ayoa)((ayon)localObject3).a.get(i)).jdField_b_of_type_JavaLangString).append("::");
              }
              for (;;)
              {
                i += 1;
                break;
                ((StringBuilder)localObject5).append(((ayoa)((ayon)localObject3).a.get(i)).jdField_b_of_type_JavaLangString);
              }
            }
          }
          aysc.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((ayig)localObject2).jdField_a_of_type_JavaLangString).ver2(aysc.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + aysc.jdField_b_of_type_JavaLangString + "}"));
        }
      }
    }
    label1809:
    if (ayif.jdField_a_of_type_JavaUtilHashMap.containsKey(localayns))
    {
      localObject2 = (ayig)ayif.jdField_a_of_type_JavaUtilHashMap.get(localayns);
      if (!((ayig)localObject2).jdField_a_of_type_Boolean)
      {
        if (ayvm.a(((ayig)localObject2).jdField_a_of_type_Long))
        {
          if (!((ayig)localObject2).jdField_b_of_type_Boolean) {
            break label2874;
          }
          i = 2;
          label1863:
          ayvm.a("all_result", "exp_object", i, 0, new String[] { ((ayig)localObject2).jdField_a_of_type_JavaLangString, ((ayig)localObject2).jdField_a_of_type_Long + "", ((ayig)localObject2).jdField_b_of_type_JavaLangString, ((ayig)localObject2).jdField_a_of_type_Int + "" });
          ((ayig)localObject2).jdField_a_of_type_Boolean = true;
          ayif.jdField_a_of_type_JavaUtilHashMap.put((aynu)localayns, localObject2);
        }
        if ((localayns instanceof aypd))
        {
          localObject3 = (aypd)localayns;
          if ((((aypd)localObject3).jdField_a_of_type_Int == -3) || (((aypd)localObject3).jdField_a_of_type_Int == -4)) {
            if (!((ayig)localObject2).jdField_b_of_type_Boolean) {
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
        ayvm.a("all_result", "exp_net_search", i, 0, new String[] { ((ayig)localObject2).jdField_a_of_type_JavaLangString, ((ayig)localObject2).jdField_a_of_type_Long + "", ((ayig)localObject2).jdField_b_of_type_JavaLangString, ((ayig)localObject2).jdField_a_of_type_Int + "" });
        localObject2 = paramView;
        if (!a(paramView, localayns)) {
          localObject2 = null;
        }
        paramView = super.getView(paramInt, (View)localObject2, paramViewGroup);
        a(paramInt, paramView, localayns);
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
          bool2 = a(paramView, localayns, paramInt, i, j, bool2);
        }
        if ((paramView != null) && (paramView.findViewById(2131365369) != null))
        {
          if (!bool2) {
            break label2886;
          }
          paramView.findViewById(2131365369).setVisibility(8);
        }
        return paramView;
        label2257:
        if (((!(localayns instanceof ayod)) || ((localayns instanceof ayor))) && (((!(localayns instanceof ayms)) && ((!(localayns instanceof aypd)) || (((aypd)localayns).jdField_a_of_type_Int != -4))) || (!ayif.b.containsKey(localayns)))) {
          break;
        }
        localObject2 = (ayig)ayif.b.get(localayns);
        if ((localayns instanceof ayoo))
        {
          localObject3 = (ayoo)localayns;
          if (!((ayig)localObject2).jdField_a_of_type_Boolean)
          {
            ((ayig)localObject2).jdField_a_of_type_Boolean = true;
            localObject5 = new StringBuilder();
            if ((((ayoo)localObject3).a != null) && (((ayoo)localObject3).a.size() > 0))
            {
              i = 0;
              while (i < ((ayoo)localObject3).a.size())
              {
                ((StringBuilder)localObject5).append(((ayoz)((ayoo)localObject3).a.get(i)).jdField_a_of_type_JavaLangString).append("::");
                i += 1;
              }
              aysc.a(null, new ReportModelDC02528().module("all_result").action("exp_relatedsearch_list").obj1("1007").ver1(((ayig)localObject2).jdField_a_of_type_JavaLangString).ver2(aysc.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + aysc.jdField_b_of_type_JavaLangString + "}"));
            }
            aysc.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((ayig)localObject2).jdField_a_of_type_JavaLangString).ver2(aysc.a(this.b)).ver5("2").ver7("{experiment_id:" + aysc.jdField_b_of_type_JavaLangString + "}"));
          }
        }
        if (((ayig)localObject2).jdField_a_of_type_Boolean) {
          break;
        }
        ((ayig)localObject2).jdField_a_of_type_Boolean = true;
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("project", aysc.a());
          ((JSONObject)localObject3).put("event_src", "client");
          ((JSONObject)localObject3).put("get_src", "web");
          ((JSONObject)localObject3).put("obj_lct", ((ayig)localObject2).jdField_a_of_type_Int);
          if ((localayns instanceof ayod)) {
            ((JSONObject)localObject3).put("tepl", ((ayod)localayns).f);
          }
          localObject5 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          aysc.a((QQAppInterface)localObject5, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((ayig)localObject2).jdField_a_of_type_Long + "").obj2(((ayig)localObject2).jdField_b_of_type_JavaLangString).ver1(((ayig)localObject2).jdField_a_of_type_JavaLangString).ver2(aysc.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject5).getCurrentAccountUin() + ayif.jdField_a_of_type_Long));
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
    paramView.findViewById(2131365369).setVisibility(0);
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
      if ((localObject instanceof aynb))
      {
        localObject = (aynb)localObject;
        k = i + 1;
        ((aynb)localObject).a(1, k);
        i = j;
        if (((aynb)localObject).b() == 2) {
          i = j + 1;
        }
        ((aynb)localObject).a(3, i);
        ((aynb)localObject).a(0, k, i);
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
        if ((localObject instanceof aypc))
        {
          localObject = (aypc)localObject;
          k += 1;
          ((aypc)localObject).a(k, i, j);
          m = i;
          i = k;
          k = j;
          j = m;
        }
        else
        {
          m = k;
          if ((localObject instanceof ayms))
          {
            localObject = (ayms)localObject;
            m = k + 1;
            ((ayms)localObject).a(m, i, j);
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
      QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "onDecodeTaskCompleted, remainingTasks : " + paramInt1 + ", type : " + paramInt2 + ", uin : " + paramString + ", avatar : " + paramBitmap + ", mFaceDecoder.isPausing() : " + this.jdField_a_of_type_Bdbb.a() + ", mScrollState : " + this.jdField_a_of_type_Int);
    }
    if ((!this.jdField_a_of_type_Bdbb.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1);
        aynr localaynr;
        ayqo localayqo;
        aywb localaywb;
        if (((localView.getTag(2131379971) instanceof aynr)) && ((localView.getTag(2131379973) instanceof ayqo)) && ((localView.getTag(2131379976) instanceof aywb)))
        {
          localaynr = (aynr)localView.getTag(2131379971);
          localayqo = (ayqo)localView.getTag(2131379973);
          localaywb = (aywb)localView.getTag(2131379976);
          if ((localaynr.c() == paramInt2) && (paramString.equals(localaynr.b()))) {
            localayqo.a(localaynr, localaywb, paramBitmap);
          }
        }
        if ((localView instanceof ViewGroup))
        {
          int i = 0;
          while (i < ((ViewGroup)localView).getChildCount())
          {
            localaynr = (aynr)((ViewGroup)localView).getChildAt(i).getTag(2131379971);
            if ((localaynr != null) && (localaynr.c() == paramInt2) && (paramString.equals(localaynr.b())))
            {
              localayqo = (ayqo)((ViewGroup)localView).getChildAt(i).getTag(2131379973);
              localaywb = (aywb)((ViewGroup)localView).getChildAt(i).getTag(2131379976);
              if ((localayqo != null) && (localaywb != null)) {
                localayqo.a(localaynr, localaywb, paramBitmap);
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
    if (this.jdField_a_of_type_Bhtv != null) {
      this.jdField_a_of_type_Bhtv.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    this.jdField_a_of_type_Aysw.a(paramInt1, paramInt2, paramInt3);
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
      if (this.jdField_a_of_type_Bdbb.a()) {
        this.jdField_a_of_type_Bdbb.b();
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
          aynr localaynr = (aynr)((ViewGroup)localView).getChildAt(j).getTag(2131379971);
          ayqo localayqo = (ayqo)((ViewGroup)localView).getChildAt(j).getTag(2131379973);
          aywb localaywb = (aywb)((ViewGroup)localView).getChildAt(j).getTag(2131379976);
          if ((localayqo != null) && (localaynr != null) && (paramAbsListView != null)) {
            localayqo.a(localaynr, localaywb);
          }
          j += 1;
        }
      }
      i += 1;
      continue;
      this.jdField_a_of_type_Bdbb.a();
      this.jdField_a_of_type_Bdbb.c();
    }
    if (this.jdField_a_of_type_Bhtv != null) {
      this.jdField_a_of_type_Bhtv.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.jdField_a_of_type_Aysw.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayjq
 * JD-Core Version:    0.7.0.1
 */