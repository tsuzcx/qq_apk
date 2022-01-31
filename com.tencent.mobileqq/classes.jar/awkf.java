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

public class awkf
  extends awkc
  implements baxl, bfob
{
  protected int a;
  private awti jdField_a_of_type_Awti = new awti();
  private baxk jdField_a_of_type_Baxk;
  private bfob jdField_a_of_type_Bfob;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  public int b = -1;
  
  public awkf(ListView paramListView, baxk parambaxk, bfob parambfob, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Baxk = parambaxk;
    parambaxk.a(this);
    paramListView.setOnScrollListener(this);
    this.jdField_a_of_type_Bfob = parambfob;
    this.b = paramInt;
  }
  
  private awta a(int paramInt)
  {
    awoe localawoe = a(paramInt);
    if (localawoe == null) {
      return null;
    }
    if (!(localawoe instanceof awta)) {
      return null;
    }
    return (awta)localawoe;
  }
  
  private void a(int paramInt, View paramView, awoe paramawoe)
  {
    if ((paramView == null) || (paramawoe == null)) {}
    for (;;)
    {
      return;
      if ((paramawoe instanceof awpm))
      {
        paramView = (awwq)paramView.getTag(2131379213);
        if ((paramView instanceof awtc)) {}
        for (paramView = ((awtc)paramView).a(); paramView != null; paramView = null)
        {
          this.jdField_a_of_type_Awti.a(paramInt, paramView);
          return;
        }
      }
    }
  }
  
  private boolean a(View paramView, awoe paramawoe)
  {
    if ((paramView == null) || (paramawoe == null)) {
      return false;
    }
    if ((paramawoe instanceof awpm))
    {
      awwq localawwq = (awwq)paramView.getTag(2131379213);
      paramView = null;
      if ((localawwq instanceof awtc)) {
        paramView = ((awtc)localawwq).a();
      }
      if (paramView == null) {
        return false;
      }
      if ((((awpm)paramawoe).f() != paramView.c()) || (((awpm)paramawoe).h() != paramView.b())) {
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
  
  private boolean a(View paramView, awoe paramawoe, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt2 == 59)
    {
      if (paramView == null) {
        break label203;
      }
      paramView = (awwq)paramView.getTag(2131379213);
      if (!(paramView instanceof awtc)) {
        break label71;
      }
      paramView = (awtc)paramView;
    }
    for (;;)
    {
      if ((paramView != null) && ((paramView instanceof awtm)))
      {
        if (paramInt1 != 0) {
          break label76;
        }
        ((awtm)paramView).a(false);
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
            if ((!(localObject instanceof awnn)) || (((awnn)localObject).jdField_a_of_type_Boolean)) {
              break label197;
            }
          }
        }
      }
      label167:
      label197:
      for (Object localObject = ((awnn)localObject).a().a();; localObject = null)
      {
        if ((paramawoe != null) && (localObject != null) && (((List)localObject).contains(paramawoe))) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 == 0) {
            break label167;
          }
          ((awtm)paramView).a(false);
          break;
        }
        break;
        paramView = a(paramInt1 - 1);
        if ((!(paramView instanceof awsy)) || (((awsy)paramView).a() != 1)) {
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
    if ((a(paramInt) instanceof awnd)) {
      return ((awnd)a(paramInt)).b();
    }
    if ((a(paramInt) instanceof awne)) {
      return ((awne)a(paramInt)).d();
    }
    return 0;
  }
  
  protected awrb a(int paramInt)
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
      return new awrv(this.jdField_a_of_type_Baxk);
    case 41: 
      return new awqz(this.jdField_a_of_type_Baxk);
    case 3: 
      return new awrr(this.jdField_a_of_type_Baxk, false);
    case 12: 
      return new awrr(this.jdField_a_of_type_Baxk, true);
    case 57: 
      return new awqv();
    case 0: 
      return new awrw();
    case 49: 
      return new awrp();
    case 15: 
      return new awrw();
    case 2: 
    case 8: 
      return new awrk(this.jdField_a_of_type_Baxk);
    case 9: 
      return new awrt();
    case 14: 
      return new awrt();
    case 10: 
      return new bgqa();
    case 11: 
      return new apfi(this.jdField_a_of_type_Baxk);
    case 13: 
      return new awqm(this.jdField_a_of_type_Baxk);
    case 56: 
      return new awrc(this.jdField_a_of_type_Baxk);
    case 60: 
      return new awrg(this.jdField_a_of_type_Baxk);
    case 16: 
      return new awrv(this.jdField_a_of_type_Baxk);
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 31: 
    case 40: 
      return new awqh(this.jdField_a_of_type_Baxk, a(paramInt), this);
    case 29: 
    case 30: 
    case 36: 
      return new awqw();
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
      return new awsa(this.jdField_a_of_type_Baxk, this);
    case 46: 
      return new awrl(this.jdField_a_of_type_Baxk);
    }
    return new awrm(this.jdField_a_of_type_Baxk, this);
  }
  
  protected awwq a(int paramInt, ViewGroup paramViewGroup)
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
      return new awye(paramViewGroup, 2131562371);
    case 41: 
      return new awwm(paramViewGroup);
    case 3: 
      return new awya(paramViewGroup);
    case 12: 
      return new awxy(paramViewGroup);
    case 57: 
      return new awwk(paramViewGroup);
    case 0: 
    case 15: 
      localObject1 = a(paramInt);
      if (!(localObject1 instanceof awnn)) {
        break;
      }
    }
    for (boolean bool1 = ((awnn)localObject1).a();; bool1 = false)
    {
      if (paramInt != 0) {
        bool2 = true;
      }
      return new awyc(paramViewGroup, bool2, bool1);
      return new awye(paramViewGroup, 2131559450);
      return new awxz(paramViewGroup);
      return new awyb(paramViewGroup, 2131562391, 2130845182, -1);
      return new awyb(paramViewGroup, 2131562391, 2130845182, 12);
      return new awyf(paramViewGroup, 2131559645);
      return new awwh(paramViewGroup, 2131562375);
      return new awwr(paramViewGroup, 2131562377);
      return new awwt(paramViewGroup, 2131562378);
      return new awwg(paramViewGroup, 2131562420);
      return new awye(paramViewGroup, 2131562372);
      return new awye(paramViewGroup, 2131562379);
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = a(paramInt);
      localObject2 = awtk.a().a((QQAppInterface)localObject2, paramViewGroup.getContext(), (awoe)localObject1);
      if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof awpm))) {
        ((awpm)localObject1).c(((awta)localObject2).b());
      }
      if (localObject2 == null) {
        return new awwk(paramViewGroup);
      }
      return ((awta)localObject2).a();
      return new awxx(paramViewGroup, a(paramInt));
      localObject1 = a(paramInt);
      if ((localObject1 instanceof awpp)) {
        return new awxw(paramViewGroup, ((awpp)localObject1).d());
      }
      throw new RuntimeException("model type is TYPE_UNITE_ENTRANCE_SUB_ITEM_COMMON_TEXT, but model item is not instance SearchResultModelForEntrance.");
      localObject1 = a(paramInt);
      if ((localObject1 instanceof awop))
      {
        localObject1 = (awop)localObject1;
        switch (((awop)localObject1).d())
        {
        case 5: 
        case 10: 
        default: 
          throw new RuntimeException("NetSearchTemplateBaseItem.getLayoutId() is " + ((awop)localObject1).e() + " which is not supported!!!");
        case 2: 
          return new awwu(paramViewGroup, ((awop)localObject1).e());
        case 3: 
          return new awxq(paramViewGroup, ((awop)localObject1).e());
        case 4: 
          return new awwv(paramViewGroup, ((awop)localObject1).e());
        case 7: 
          return new awxc(paramViewGroup, ((awop)localObject1).e());
        case 6: 
          return new awxp(paramViewGroup, ((awop)localObject1).e());
        case 8: 
          return new awxn(paramViewGroup, ((awop)localObject1).e());
        case 9: 
          return new awxm(paramViewGroup, ((awop)localObject1).e());
        case 11: 
          return new awwz(paramViewGroup, ((awop)localObject1).e());
        case 12: 
          return new awwx(paramViewGroup, ((awop)localObject1).e());
        case 13: 
          return new awxa(paramViewGroup, ((awop)localObject1).e());
        case 14: 
          return new awxo(paramViewGroup, ((awop)localObject1).e());
        case 15: 
          return new awxk(paramViewGroup, ((awop)localObject1).e());
        case 16: 
          return new awxf(paramViewGroup, ((awop)localObject1).e());
        case 17: 
          return new awxh(paramViewGroup, ((awop)localObject1).e());
        }
        return new awxe(paramViewGroup, ((awop)localObject1).e());
      }
      throw new RuntimeException("model type is TYPE_UNITE_TEMPLATE_NORMAL or TYPE_UNITE_TEMPLATE_NEWS, but model item is not instance NetSearchTemplateBaseItem.");
      return new awyf(paramViewGroup, 2131559451);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 12;
    if ((super.a(paramInt) instanceof awnp)) {
      i = 41;
    }
    do
    {
      return i;
      if ((super.a(paramInt) instanceof awnt)) {
        return 3;
      }
    } while ((super.a(paramInt) instanceof awly));
    if (((super.a(paramInt) instanceof awnn)) && (this.b != 12))
    {
      if (((awnn)super.a(paramInt)).jdField_a_of_type_Boolean) {
        return 0;
      }
      return 57;
    }
    if (((super.a(paramInt) instanceof awnn)) && (this.b == 12))
    {
      if (((awnn)super.a(paramInt)).jdField_a_of_type_Boolean) {
        return 15;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof awno))
    {
      awno localawno = (awno)super.a(paramInt);
      if ((localawno != null) && (localawno.jdField_a_of_type_Boolean)) {
        return 49;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof awny)) {
      return 2;
    }
    if ((super.a(paramInt) instanceof awnh)) {
      return 5;
    }
    if ((super.a(paramInt) instanceof awnu)) {
      return 56;
    }
    if ((super.a(paramInt) instanceof awnl)) {
      return 6;
    }
    if ((super.a(paramInt) instanceof awnw)) {
      return 60;
    }
    if ((super.a(paramInt) instanceof awnj)) {
      return 8;
    }
    if ((super.a(paramInt) instanceof awnf)) {
      return 16;
    }
    if (((super.a(paramInt) instanceof awnv)) && (this.b != 12)) {
      return 9;
    }
    if (((super.a(paramInt) instanceof awnv)) && (this.b == 12)) {
      return 14;
    }
    if ((a(paramInt) instanceof bgqe)) {
      return 10;
    }
    if ((a(paramInt) instanceof apfl)) {
      return 11;
    }
    if (((super.a(paramInt) instanceof awnq)) || ((super.a(paramInt) instanceof awns))) {
      return 13;
    }
    if ((a(paramInt) instanceof awnx)) {
      return 17;
    }
    if ((a(paramInt) instanceof awnr)) {
      return 19;
    }
    if ((a(paramInt) instanceof awpm)) {
      return 59;
    }
    if ((a(paramInt) instanceof awne))
    {
      switch (((awne)a(paramInt)).d())
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
    if ((a(paramInt) instanceof awpp))
    {
      switch (((awpp)a(paramInt)).jdField_a_of_type_Int)
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
    if ((a(paramInt) instanceof awop))
    {
      switch (((awop)a(paramInt)).d())
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
    if ((a(paramInt) instanceof awpk)) {
      return 46;
    }
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    awoe localawoe = a(paramInt);
    Object localObject3;
    int j;
    Object localObject6;
    Object localObject7;
    Object localObject2;
    if (awiu.a(localawoe) > 0)
    {
      Object localObject1;
      if (awiu.b.containsKey(localawoe))
      {
        localObject1 = (awiv)awiu.b.get(localawoe);
        if (!((awiv)localObject1).jdField_a_of_type_Boolean)
        {
          ((awiv)localObject1).jdField_a_of_type_Boolean = true;
          localObject3 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject3).put("project", awso.a());
        ((JSONObject)localObject3).put("event_src", "client");
        ((JSONObject)localObject3).put("get_src", "native");
        ((JSONObject)localObject3).put("obj_lct", ((awiv)localObject1).jdField_a_of_type_Int);
        localObject4 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        awso.a((QQAppInterface)localObject4, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((awiv)localObject1).jdField_a_of_type_Long + "").obj2(((awiv)localObject1).jdField_b_of_type_JavaLangString).ver1(((awiv)localObject1).jdField_a_of_type_JavaLangString).ver2(awso.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject4).getCurrentAccountUin() + awiu.jdField_a_of_type_Long));
        ((awiv)localObject1).jdField_a_of_type_Boolean = true;
        awiu.b.put(localawoe, localObject1);
        if ((localawoe instanceof awof))
        {
          localObject1 = (awof)localawoe;
          localObject3 = ((awof)localObject1).a();
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            j = Math.min(((List)localObject3).size(), ((awof)localObject1).a());
            i = 0;
            if (i < j) {
              if (awiu.b.containsKey(((List)localObject3).get(i)))
              {
                localObject4 = (awiv)awiu.b.get(((List)localObject3).get(i));
                if (!((awiv)localObject4).jdField_a_of_type_Boolean)
                {
                  ((awiv)localObject4).jdField_a_of_type_Boolean = true;
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
            ((JSONObject)localObject6).put("project", awso.a());
            ((JSONObject)localObject6).put("event_src", "client");
            ((JSONObject)localObject6).put("get_src", "native");
            ((JSONObject)localObject6).put("obj_lct", ((awiv)localObject4).jdField_a_of_type_Int);
            if (!(((List)localObject3).get(i) instanceof awol)) {
              break label716;
            }
            localObject7 = (awol)((List)localObject3).get(i);
            if (!((awol)localObject7).c()) {
              break;
            }
            localObject1 = "1";
            ((awiv)localObject4).jdField_b_of_type_JavaLangString = ((awol)localObject7).e();
            localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            awso.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((awiv)localObject4).jdField_a_of_type_Long + "").obj2(((awiv)localObject4).jdField_b_of_type_JavaLangString).ver1(((awiv)localObject4).jdField_a_of_type_JavaLangString).ver2(awso.a(this.b)).ver3((String)localObject1).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + awiu.jdField_a_of_type_Long));
            ((awiv)localObject4).jdField_a_of_type_Boolean = true;
            awiu.b.put(((List)localObject3).get(i), localObject4);
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
            awso.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localJSONException2.jdField_a_of_type_Long + "").obj2(localJSONException2.jdField_b_of_type_JavaLangString).ver1(localJSONException2.jdField_a_of_type_JavaLangString).ver2(awso.a(this.b)).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + awiu.jdField_a_of_type_Long));
            localJSONException2.jdField_a_of_type_Boolean = true;
            awiu.b.put(((List)localObject3).get(i), localJSONException2);
          }
        }
      }
    }
    Object localObject5;
    if ((localawoe instanceof awnd))
    {
      localObject2 = (awnd)localawoe;
      if ((((awnd)localObject2).a() != null) && (((awnd)localObject2).a().size() > 0))
      {
        i = 0;
        for (;;)
        {
          if (i >= ((awnd)localObject2).a().size()) {
            break label1809;
          }
          localObject3 = (awoe)((awnd)localObject2).a().get(i);
          if (awiu.b.containsKey(localObject3))
          {
            localObject3 = (awiv)awiu.b.get(localObject3);
            if (!((awiv)localObject3).jdField_a_of_type_Boolean)
            {
              ((awiv)localObject3).jdField_a_of_type_Boolean = true;
              localObject5 = new JSONObject();
            }
          }
          try
          {
            ((JSONObject)localObject5).put("project", awso.a());
            ((JSONObject)localObject5).put("event_src", "client");
            ((JSONObject)localObject5).put("get_src", "web");
            ((JSONObject)localObject5).put("obj_lct", ((awiv)localObject3).jdField_a_of_type_Int);
            localObject6 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            awso.a((QQAppInterface)localObject6, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((awiv)localObject3).jdField_a_of_type_Long + "").obj2(((awiv)localObject3).jdField_b_of_type_JavaLangString).ver1(((awiv)localObject3).jdField_a_of_type_JavaLangString).ver2(awso.a(this.b)).ver7(((JSONObject)localObject5).toString()).session_id(((QQAppInterface)localObject6).getCurrentAccountUin() + awiu.jdField_a_of_type_Long));
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
    else if ((localawoe instanceof awow))
    {
      localObject2 = ((awow)localawoe).a;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1809;
          }
          localObject3 = (awov)((Iterator)localObject2).next();
          if (awiu.b.containsKey(localObject3))
          {
            localObject5 = (awiv)awiu.b.get(localObject3);
            if (!((awiv)localObject5).jdField_a_of_type_Boolean)
            {
              ((awiv)localObject5).jdField_a_of_type_Boolean = true;
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("project", awso.a());
                localJSONObject.put("event_src", "client");
                localJSONObject.put("get_src", "web");
                localJSONObject.put("obj_lct", ((awiv)localObject5).jdField_a_of_type_Int);
                localJSONObject.put("extra_info", ((awov)localObject3).jdField_b_of_type_JavaLangString);
                localJSONObject.put("tepl", ((awov)localObject3).f);
                localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                awso.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((awov)localObject3).jdField_a_of_type_Long + "").obj2(((awov)localObject3).j).ver1(((awiv)localObject5).jdField_a_of_type_JavaLangString).ver2(awso.a(this.b)).ver7(localJSONObject.toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + awiu.jdField_a_of_type_Long));
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
      if (!(localawoe instanceof awoz)) {
        break label2257;
      }
      if (awiu.b.containsKey(localawoe))
      {
        localObject2 = (awiv)awiu.b.get(localawoe);
        localObject3 = (awoz)localawoe;
        if (!((awiv)localObject2).jdField_a_of_type_Boolean)
        {
          ((awiv)localObject2).jdField_a_of_type_Boolean = true;
          localObject5 = new StringBuilder();
          if ((((awoz)localObject3).a != null) && (((awoz)localObject3).a.size() > 0))
          {
            i = 0;
            if (i < ((awoz)localObject3).a.size())
            {
              if (i != ((awoz)localObject3).a.size() - 1) {
                ((StringBuilder)localObject5).append(((awom)((awoz)localObject3).a.get(i)).jdField_b_of_type_JavaLangString).append("::");
              }
              for (;;)
              {
                i += 1;
                break;
                ((StringBuilder)localObject5).append(((awom)((awoz)localObject3).a.get(i)).jdField_b_of_type_JavaLangString);
              }
            }
          }
          awso.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((awiv)localObject2).jdField_a_of_type_JavaLangString).ver2(awso.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + awso.jdField_b_of_type_JavaLangString + "}"));
        }
      }
    }
    label1809:
    if (awiu.jdField_a_of_type_JavaUtilHashMap.containsKey(localawoe))
    {
      localObject2 = (awiv)awiu.jdField_a_of_type_JavaUtilHashMap.get(localawoe);
      if (!((awiv)localObject2).jdField_a_of_type_Boolean)
      {
        if (awvy.a(((awiv)localObject2).jdField_a_of_type_Long))
        {
          if (!((awiv)localObject2).jdField_b_of_type_Boolean) {
            break label2874;
          }
          i = 2;
          label1863:
          awvy.a("all_result", "exp_object", i, 0, new String[] { ((awiv)localObject2).jdField_a_of_type_JavaLangString, ((awiv)localObject2).jdField_a_of_type_Long + "", ((awiv)localObject2).jdField_b_of_type_JavaLangString, ((awiv)localObject2).jdField_a_of_type_Int + "" });
          ((awiv)localObject2).jdField_a_of_type_Boolean = true;
          awiu.jdField_a_of_type_JavaUtilHashMap.put((awog)localawoe, localObject2);
        }
        if ((localawoe instanceof awpp))
        {
          localObject3 = (awpp)localawoe;
          if ((((awpp)localObject3).jdField_a_of_type_Int == -3) || (((awpp)localObject3).jdField_a_of_type_Int == -4)) {
            if (!((awiv)localObject2).jdField_b_of_type_Boolean) {
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
        awvy.a("all_result", "exp_net_search", i, 0, new String[] { ((awiv)localObject2).jdField_a_of_type_JavaLangString, ((awiv)localObject2).jdField_a_of_type_Long + "", ((awiv)localObject2).jdField_b_of_type_JavaLangString, ((awiv)localObject2).jdField_a_of_type_Int + "" });
        localObject2 = paramView;
        if (!a(paramView, localawoe)) {
          localObject2 = null;
        }
        paramView = super.getView(paramInt, (View)localObject2, paramViewGroup);
        a(paramInt, paramView, localawoe);
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
          bool2 = a(paramView, localawoe, paramInt, i, j, bool2);
        }
        if ((paramView != null) && (paramView.findViewById(2131365283) != null))
        {
          if (!bool2) {
            break label2886;
          }
          paramView.findViewById(2131365283).setVisibility(8);
        }
        return paramView;
        label2257:
        if (((!(localawoe instanceof awop)) || ((localawoe instanceof awpd))) && (((!(localawoe instanceof awne)) && ((!(localawoe instanceof awpp)) || (((awpp)localawoe).jdField_a_of_type_Int != -4))) || (!awiu.b.containsKey(localawoe)))) {
          break;
        }
        localObject2 = (awiv)awiu.b.get(localawoe);
        if ((localawoe instanceof awpa))
        {
          localObject3 = (awpa)localawoe;
          if (!((awiv)localObject2).jdField_a_of_type_Boolean)
          {
            ((awiv)localObject2).jdField_a_of_type_Boolean = true;
            localObject5 = new StringBuilder();
            if ((((awpa)localObject3).a != null) && (((awpa)localObject3).a.size() > 0))
            {
              i = 0;
              while (i < ((awpa)localObject3).a.size())
              {
                ((StringBuilder)localObject5).append(((awpl)((awpa)localObject3).a.get(i)).jdField_a_of_type_JavaLangString).append("::");
                i += 1;
              }
              awso.a(null, new ReportModelDC02528().module("all_result").action("exp_relatedsearch_list").obj1("1007").ver1(((awiv)localObject2).jdField_a_of_type_JavaLangString).ver2(awso.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + awso.jdField_b_of_type_JavaLangString + "}"));
            }
            awso.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((awiv)localObject2).jdField_a_of_type_JavaLangString).ver2(awso.a(this.b)).ver5("2").ver7("{experiment_id:" + awso.jdField_b_of_type_JavaLangString + "}"));
          }
        }
        if (((awiv)localObject2).jdField_a_of_type_Boolean) {
          break;
        }
        ((awiv)localObject2).jdField_a_of_type_Boolean = true;
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("project", awso.a());
          ((JSONObject)localObject3).put("event_src", "client");
          ((JSONObject)localObject3).put("get_src", "web");
          ((JSONObject)localObject3).put("obj_lct", ((awiv)localObject2).jdField_a_of_type_Int);
          if ((localawoe instanceof awop)) {
            ((JSONObject)localObject3).put("tepl", ((awop)localawoe).f);
          }
          localObject5 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          awso.a((QQAppInterface)localObject5, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((awiv)localObject2).jdField_a_of_type_Long + "").obj2(((awiv)localObject2).jdField_b_of_type_JavaLangString).ver1(((awiv)localObject2).jdField_a_of_type_JavaLangString).ver2(awso.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject5).getCurrentAccountUin() + awiu.jdField_a_of_type_Long));
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
    paramView.findViewById(2131365283).setVisibility(0);
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
      if ((localObject instanceof awnn))
      {
        localObject = (awnn)localObject;
        k = i + 1;
        ((awnn)localObject).a(1, k);
        i = j;
        if (((awnn)localObject).b() == 2) {
          i = j + 1;
        }
        ((awnn)localObject).a(3, i);
        ((awnn)localObject).a(0, k, i);
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
        if ((localObject instanceof awpo))
        {
          localObject = (awpo)localObject;
          k += 1;
          ((awpo)localObject).a(k, i, j);
          m = i;
          i = k;
          k = j;
          j = m;
        }
        else
        {
          m = k;
          if ((localObject instanceof awne))
          {
            localObject = (awne)localObject;
            m = k + 1;
            ((awne)localObject).a(m, i, j);
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
      QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "onDecodeTaskCompleted, remainingTasks : " + paramInt1 + ", type : " + paramInt2 + ", uin : " + paramString + ", avatar : " + paramBitmap + ", mFaceDecoder.isPausing() : " + this.jdField_a_of_type_Baxk.a() + ", mScrollState : " + this.jdField_a_of_type_Int);
    }
    if ((!this.jdField_a_of_type_Baxk.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1);
        awod localawod;
        awra localawra;
        awwn localawwn;
        if (((localView.getTag(2131379208) instanceof awod)) && ((localView.getTag(2131379210) instanceof awra)) && ((localView.getTag(2131379213) instanceof awwn)))
        {
          localawod = (awod)localView.getTag(2131379208);
          localawra = (awra)localView.getTag(2131379210);
          localawwn = (awwn)localView.getTag(2131379213);
          if ((localawod.c() == paramInt2) && (paramString.equals(localawod.b()))) {
            localawra.a(localawod, localawwn, paramBitmap);
          }
        }
        if ((localView instanceof ViewGroup))
        {
          int i = 0;
          while (i < ((ViewGroup)localView).getChildCount())
          {
            localawod = (awod)((ViewGroup)localView).getChildAt(i).getTag(2131379208);
            if ((localawod != null) && (localawod.c() == paramInt2) && (paramString.equals(localawod.b())))
            {
              localawra = (awra)((ViewGroup)localView).getChildAt(i).getTag(2131379210);
              localawwn = (awwn)((ViewGroup)localView).getChildAt(i).getTag(2131379213);
              if ((localawra != null) && (localawwn != null)) {
                localawra.a(localawod, localawwn, paramBitmap);
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
    if (this.jdField_a_of_type_Bfob != null) {
      this.jdField_a_of_type_Bfob.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    this.jdField_a_of_type_Awti.a(paramInt1, paramInt2, paramInt3);
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
      if (this.jdField_a_of_type_Baxk.a()) {
        this.jdField_a_of_type_Baxk.b();
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
          awod localawod = (awod)((ViewGroup)localView).getChildAt(j).getTag(2131379208);
          awra localawra = (awra)((ViewGroup)localView).getChildAt(j).getTag(2131379210);
          awwn localawwn = (awwn)((ViewGroup)localView).getChildAt(j).getTag(2131379213);
          if ((localawra != null) && (localawod != null) && (paramAbsListView != null)) {
            localawra.a(localawod, localawwn);
          }
          j += 1;
        }
      }
      i += 1;
      continue;
      this.jdField_a_of_type_Baxk.a();
      this.jdField_a_of_type_Baxk.c();
    }
    if (this.jdField_a_of_type_Bfob != null) {
      this.jdField_a_of_type_Bfob.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.jdField_a_of_type_Awti.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkf
 * JD-Core Version:    0.7.0.1
 */