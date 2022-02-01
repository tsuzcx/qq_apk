import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class bcbl
  extends bcbi
  implements aoog, blih
{
  protected int a;
  private aoof jdField_a_of_type_Aoof;
  private bcks jdField_a_of_type_Bcks = new bcks();
  private blih jdField_a_of_type_Blih;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  public int b = -1;
  
  public bcbl(ListView paramListView, aoof paramaoof, blih paramblih, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Aoof = paramaoof;
    paramaoof.a(this);
    paramListView.setOnScrollListener(this);
    this.jdField_a_of_type_Blih = paramblih;
    this.b = paramInt;
  }
  
  private bckk a(int paramInt)
  {
    bcfp localbcfp = a(paramInt);
    if (localbcfp == null) {
      return null;
    }
    if (!(localbcfp instanceof bckk)) {
      return null;
    }
    return (bckk)localbcfp;
  }
  
  private void a(int paramInt, View paramView, bcfp parambcfp)
  {
    if ((paramView == null) || (parambcfp == null)) {}
    for (;;)
    {
      return;
      if ((parambcfp instanceof bcgx))
      {
        paramView = (bcoa)paramView.getTag(2131381115);
        if ((paramView instanceof bckm)) {}
        for (paramView = ((bckm)paramView).a(); paramView != null; paramView = null)
        {
          this.jdField_a_of_type_Bcks.a(paramInt, paramView);
          return;
        }
      }
    }
  }
  
  private boolean a(View paramView, bcfp parambcfp)
  {
    if ((paramView == null) || (parambcfp == null)) {
      return false;
    }
    if ((parambcfp instanceof bcgx))
    {
      bcoa localbcoa = (bcoa)paramView.getTag(2131381115);
      paramView = null;
      if ((localbcoa instanceof bckm)) {
        paramView = ((bckm)localbcoa).a();
      }
      if (paramView == null) {
        return false;
      }
      if ((((bcgx)parambcfp).f() != paramView.c()) || (((bcgx)parambcfp).h() != paramView.b())) {
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
  
  private boolean a(View paramView, bcfp parambcfp, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt2 == 59)
    {
      if (paramView == null) {
        break label203;
      }
      paramView = (bcoa)paramView.getTag(2131381115);
      if (!(paramView instanceof bckm)) {
        break label71;
      }
      paramView = (bckm)paramView;
    }
    for (;;)
    {
      if ((paramView != null) && ((paramView instanceof bckw)))
      {
        if (paramInt1 != 0) {
          break label76;
        }
        ((bckw)paramView).a(false);
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
            if ((!(localObject instanceof bcey)) || (((bcey)localObject).jdField_a_of_type_Boolean)) {
              break label197;
            }
          }
        }
      }
      label167:
      label197:
      for (Object localObject = ((bcey)localObject).a().a();; localObject = null)
      {
        if ((parambcfp != null) && (localObject != null) && (((List)localObject).contains(parambcfp))) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 == 0) {
            break label167;
          }
          ((bckw)paramView).a(false);
          break;
        }
        break;
        paramView = a(paramInt1 - 1);
        if ((!(paramView instanceof bcki)) || (((bcki)paramView).a() != 1)) {
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
    if ((a(paramInt) instanceof bceo)) {
      return ((bceo)a(paramInt)).b();
    }
    if ((a(paramInt) instanceof bcep)) {
      return ((bcep)a(paramInt)).d();
    }
    return 0;
  }
  
  protected bcil a(int paramInt)
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
      return new bcjf(this.jdField_a_of_type_Aoof);
    case 41: 
      return new bcij(this.jdField_a_of_type_Aoof);
    case 3: 
      return new bcjb(this.jdField_a_of_type_Aoof, false);
    case 12: 
      return new bcjb(this.jdField_a_of_type_Aoof, true);
    case 57: 
      return new bcif();
    case 0: 
      return new bcjg();
    case 49: 
      return new bciz();
    case 15: 
      return new bcjg();
    case 2: 
    case 8: 
      return new bciu(this.jdField_a_of_type_Aoof);
    case 9: 
      return new bcjd();
    case 14: 
      return new bcjd();
    case 10: 
      return new bmll();
    case 11: 
      return new atzx(this.jdField_a_of_type_Aoof);
    case 13: 
      return new bchw(this.jdField_a_of_type_Aoof);
    case 56: 
      return new bcim(this.jdField_a_of_type_Aoof);
    case 60: 
      return new bciq(this.jdField_a_of_type_Aoof);
    case 16: 
      return new bcjf(this.jdField_a_of_type_Aoof);
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 31: 
    case 40: 
      return new bchs(this.jdField_a_of_type_Aoof, a(paramInt), this);
    case 29: 
    case 30: 
    case 36: 
      return new bcig();
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
      return new bcjk(this.jdField_a_of_type_Aoof, this);
    case 46: 
      return new bciv(this.jdField_a_of_type_Aoof);
    }
    return new bciw(this.jdField_a_of_type_Aoof, this);
  }
  
  protected bcoa a(int paramInt, ViewGroup paramViewGroup)
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
      return new bcpo(paramViewGroup, 2131562864);
    case 41: 
      return new bcnw(paramViewGroup);
    case 3: 
      return new bcpk(paramViewGroup);
    case 12: 
      return new bcpi(paramViewGroup);
    case 57: 
      return new bcnu(paramViewGroup);
    case 0: 
    case 15: 
      localObject1 = a(paramInt);
      if (!(localObject1 instanceof bcey)) {
        break;
      }
    }
    for (boolean bool1 = ((bcey)localObject1).a();; bool1 = false)
    {
      if (paramInt != 0) {
        bool2 = true;
      }
      return new bcpm(paramViewGroup, bool2, bool1);
      return new bcpo(paramViewGroup, 2131559638);
      return new bcpj(paramViewGroup);
      return new bcpl(paramViewGroup, 2131562884, 2130846042, -1);
      return new bcpl(paramViewGroup, 2131562884, 2130846042, 12);
      return new bcpp(paramViewGroup, 2131559839);
      return new bcnr(paramViewGroup, 2131562868);
      return new bcob(paramViewGroup, 2131562870);
      return new bcod(paramViewGroup, 2131562871);
      return new bcnq(paramViewGroup, 2131562913);
      return new bcpo(paramViewGroup, 2131562865);
      return new bcpo(paramViewGroup, 2131562872);
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = a(paramInt);
      localObject2 = bcku.a().a((QQAppInterface)localObject2, paramViewGroup.getContext(), (bcfp)localObject1);
      if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof bcgx))) {
        ((bcgx)localObject1).c(((bckk)localObject2).b());
      }
      if (localObject2 == null) {
        return new bcnu(paramViewGroup);
      }
      return ((bckk)localObject2).a();
      return new bcph(paramViewGroup, a(paramInt));
      localObject1 = a(paramInt);
      if ((localObject1 instanceof bcha)) {
        return new bcpg(paramViewGroup, ((bcha)localObject1).d());
      }
      throw new RuntimeException("model type is TYPE_UNITE_ENTRANCE_SUB_ITEM_COMMON_TEXT, but model item is not instance SearchResultModelForEntrance.");
      localObject1 = a(paramInt);
      if ((localObject1 instanceof bcga))
      {
        localObject1 = (bcga)localObject1;
        switch (((bcga)localObject1).d())
        {
        case 5: 
        case 10: 
        default: 
          throw new RuntimeException("NetSearchTemplateBaseItem.getLayoutId() is " + ((bcga)localObject1).e() + " which is not supported!!!");
        case 2: 
          return new bcoe(paramViewGroup, ((bcga)localObject1).e());
        case 3: 
          return new bcpa(paramViewGroup, ((bcga)localObject1).e());
        case 4: 
          return new bcof(paramViewGroup, ((bcga)localObject1).e());
        case 7: 
          return new bcom(paramViewGroup, ((bcga)localObject1).e());
        case 6: 
          return new bcoz(paramViewGroup, ((bcga)localObject1).e());
        case 8: 
          return new bcox(paramViewGroup, ((bcga)localObject1).e());
        case 9: 
          return new bcow(paramViewGroup, ((bcga)localObject1).e());
        case 11: 
          return new bcoj(paramViewGroup, ((bcga)localObject1).e());
        case 12: 
          return new bcoh(paramViewGroup, ((bcga)localObject1).e());
        case 13: 
          return new bcok(paramViewGroup, ((bcga)localObject1).e());
        case 14: 
          return new bcoy(paramViewGroup, ((bcga)localObject1).e());
        case 15: 
          return new bcou(paramViewGroup, ((bcga)localObject1).e());
        case 16: 
          return new bcop(paramViewGroup, ((bcga)localObject1).e());
        case 17: 
          return new bcor(paramViewGroup, ((bcga)localObject1).e());
        }
        return new bcoo(paramViewGroup, ((bcga)localObject1).e());
      }
      throw new RuntimeException("model type is TYPE_UNITE_TEMPLATE_NORMAL or TYPE_UNITE_TEMPLATE_NEWS, but model item is not instance NetSearchTemplateBaseItem.");
      return new bcpp(paramViewGroup, 2131559639);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 12;
    if ((super.a(paramInt) instanceof bcfa)) {
      i = 41;
    }
    do
    {
      return i;
      if ((super.a(paramInt) instanceof bcfe)) {
        return 3;
      }
    } while ((super.a(paramInt) instanceof bcdj));
    if (((super.a(paramInt) instanceof bcey)) && (this.b != 12))
    {
      if (((bcey)super.a(paramInt)).jdField_a_of_type_Boolean) {
        return 0;
      }
      return 57;
    }
    if (((super.a(paramInt) instanceof bcey)) && (this.b == 12))
    {
      if (((bcey)super.a(paramInt)).jdField_a_of_type_Boolean) {
        return 15;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof bcez))
    {
      bcez localbcez = (bcez)super.a(paramInt);
      if ((localbcez != null) && (localbcez.jdField_a_of_type_Boolean)) {
        return 49;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof bcfj)) {
      return 2;
    }
    if ((super.a(paramInt) instanceof bces)) {
      return 5;
    }
    if ((super.a(paramInt) instanceof bcff)) {
      return 56;
    }
    if ((super.a(paramInt) instanceof bcew)) {
      return 6;
    }
    if ((super.a(paramInt) instanceof bcfh)) {
      return 60;
    }
    if ((super.a(paramInt) instanceof bceu)) {
      return 8;
    }
    if ((super.a(paramInt) instanceof bceq)) {
      return 16;
    }
    if (((super.a(paramInt) instanceof bcfg)) && (this.b != 12)) {
      return 9;
    }
    if (((super.a(paramInt) instanceof bcfg)) && (this.b == 12)) {
      return 14;
    }
    if ((a(paramInt) instanceof bmlp)) {
      return 10;
    }
    if ((a(paramInt) instanceof auaa)) {
      return 11;
    }
    if (((super.a(paramInt) instanceof bcfb)) || ((super.a(paramInt) instanceof bcfd))) {
      return 13;
    }
    if ((a(paramInt) instanceof bcfi)) {
      return 17;
    }
    if ((a(paramInt) instanceof bcfc)) {
      return 19;
    }
    if ((a(paramInt) instanceof bcgx)) {
      return 59;
    }
    if ((a(paramInt) instanceof bcep))
    {
      switch (((bcep)a(paramInt)).d())
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
    if ((a(paramInt) instanceof bcha))
    {
      switch (((bcha)a(paramInt)).jdField_a_of_type_Int)
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
    if ((a(paramInt) instanceof bcga))
    {
      switch (((bcga)a(paramInt)).d())
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
    if ((a(paramInt) instanceof bcgv)) {
      return 46;
    }
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bcfp localbcfp = a(paramInt);
    Object localObject3;
    int j;
    int i;
    Object localObject6;
    Object localObject7;
    if (bbzx.a(localbcfp) > 0)
    {
      Object localObject1;
      if (bbzx.b.containsKey(localbcfp))
      {
        localObject1 = (bbzy)bbzx.b.get(localbcfp);
        if (!((bbzy)localObject1).jdField_a_of_type_Boolean)
        {
          ((bbzy)localObject1).jdField_a_of_type_Boolean = true;
          localObject3 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject3).put("project", bcjy.a());
        ((JSONObject)localObject3).put("event_src", "client");
        ((JSONObject)localObject3).put("get_src", "native");
        ((JSONObject)localObject3).put("obj_lct", ((bbzy)localObject1).jdField_a_of_type_Int);
        localObject4 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        bcjy.a((QQAppInterface)localObject4, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((bbzy)localObject1).jdField_a_of_type_Long + "").obj2(((bbzy)localObject1).jdField_b_of_type_JavaLangString).ver1(((bbzy)localObject1).jdField_a_of_type_JavaLangString).ver2(bcjy.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject4).getCurrentAccountUin() + bbzx.jdField_a_of_type_Long));
        ((bbzy)localObject1).jdField_a_of_type_Boolean = true;
        bbzx.b.put(localbcfp, localObject1);
        if ((localbcfp instanceof bcfq))
        {
          localObject1 = (bcfq)localbcfp;
          localObject3 = ((bcfq)localObject1).a();
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            j = Math.min(((List)localObject3).size(), ((bcfq)localObject1).a());
            i = 0;
            if (i < j) {
              if (bbzx.b.containsKey(((List)localObject3).get(i)))
              {
                localObject4 = (bbzy)bbzx.b.get(((List)localObject3).get(i));
                if (!((bbzy)localObject4).jdField_a_of_type_Boolean)
                {
                  ((bbzy)localObject4).jdField_a_of_type_Boolean = true;
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
            ((JSONObject)localObject6).put("project", bcjy.a());
            ((JSONObject)localObject6).put("event_src", "client");
            ((JSONObject)localObject6).put("get_src", "native");
            ((JSONObject)localObject6).put("obj_lct", ((bbzy)localObject4).jdField_a_of_type_Int);
            if (!(((List)localObject3).get(i) instanceof bcfw)) {
              break label716;
            }
            localObject7 = (bcfw)((List)localObject3).get(i);
            if (!((bcfw)localObject7).c()) {
              break;
            }
            localObject1 = "1";
            ((bbzy)localObject4).jdField_b_of_type_JavaLangString = ((bcfw)localObject7).e();
            localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            bcjy.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((bbzy)localObject4).jdField_a_of_type_Long + "").obj2(((bbzy)localObject4).jdField_b_of_type_JavaLangString).ver1(((bbzy)localObject4).jdField_a_of_type_JavaLangString).ver2(bcjy.a(this.b)).ver3((String)localObject1).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + bbzx.jdField_a_of_type_Long));
            ((bbzy)localObject4).jdField_a_of_type_Boolean = true;
            bbzx.b.put(((List)localObject3).get(i), localObject4);
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
            bcjy.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localJSONException2.jdField_a_of_type_Long + "").obj2(localJSONException2.jdField_b_of_type_JavaLangString).ver1(localJSONException2.jdField_a_of_type_JavaLangString).ver2(bcjy.a(this.b)).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + bbzx.jdField_a_of_type_Long));
            localJSONException2.jdField_a_of_type_Boolean = true;
            bbzx.b.put(((List)localObject3).get(i), localJSONException2);
          }
        }
      }
    }
    Object localObject5;
    if ((localbcfp instanceof bceo))
    {
      localObject2 = (bceo)localbcfp;
      if ((((bceo)localObject2).a() != null) && (((bceo)localObject2).a().size() > 0))
      {
        i = 0;
        for (;;)
        {
          if (i >= ((bceo)localObject2).a().size()) {
            break label1809;
          }
          localObject3 = (bcfp)((bceo)localObject2).a().get(i);
          if (bbzx.b.containsKey(localObject3))
          {
            localObject3 = (bbzy)bbzx.b.get(localObject3);
            if (!((bbzy)localObject3).jdField_a_of_type_Boolean)
            {
              ((bbzy)localObject3).jdField_a_of_type_Boolean = true;
              localObject5 = new JSONObject();
            }
          }
          try
          {
            ((JSONObject)localObject5).put("project", bcjy.a());
            ((JSONObject)localObject5).put("event_src", "client");
            ((JSONObject)localObject5).put("get_src", "web");
            ((JSONObject)localObject5).put("obj_lct", ((bbzy)localObject3).jdField_a_of_type_Int);
            localObject6 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            bcjy.a((QQAppInterface)localObject6, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((bbzy)localObject3).jdField_a_of_type_Long + "").obj2(((bbzy)localObject3).jdField_b_of_type_JavaLangString).ver1(((bbzy)localObject3).jdField_a_of_type_JavaLangString).ver2(bcjy.a(this.b)).ver7(((JSONObject)localObject5).toString()).session_id(((QQAppInterface)localObject6).getCurrentAccountUin() + bbzx.jdField_a_of_type_Long));
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
    else if ((localbcfp instanceof bcgh))
    {
      localObject2 = ((bcgh)localbcfp).a;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1809;
          }
          localObject3 = (bcgg)((Iterator)localObject2).next();
          if (bbzx.b.containsKey(localObject3))
          {
            localObject5 = (bbzy)bbzx.b.get(localObject3);
            if (!((bbzy)localObject5).jdField_a_of_type_Boolean)
            {
              ((bbzy)localObject5).jdField_a_of_type_Boolean = true;
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("project", bcjy.a());
                localJSONObject.put("event_src", "client");
                localJSONObject.put("get_src", "web");
                localJSONObject.put("obj_lct", ((bbzy)localObject5).jdField_a_of_type_Int);
                localJSONObject.put("extra_info", ((bcgg)localObject3).jdField_b_of_type_JavaLangString);
                localJSONObject.put("tepl", ((bcgg)localObject3).f);
                localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                bcjy.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((bcgg)localObject3).jdField_a_of_type_Long + "").obj2(((bcgg)localObject3).j).ver1(((bbzy)localObject5).jdField_a_of_type_JavaLangString).ver2(bcjy.a(this.b)).ver7(localJSONObject.toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + bbzx.jdField_a_of_type_Long));
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
      if (!(localbcfp instanceof bcgk)) {
        break label2272;
      }
      if (bbzx.b.containsKey(localbcfp))
      {
        localObject2 = (bbzy)bbzx.b.get(localbcfp);
        localObject3 = (bcgk)localbcfp;
        if (!((bbzy)localObject2).jdField_a_of_type_Boolean)
        {
          ((bbzy)localObject2).jdField_a_of_type_Boolean = true;
          localObject5 = new StringBuilder();
          if ((((bcgk)localObject3).a != null) && (((bcgk)localObject3).a.size() > 0))
          {
            i = 0;
            if (i < ((bcgk)localObject3).a.size())
            {
              if (i != ((bcgk)localObject3).a.size() - 1) {
                ((StringBuilder)localObject5).append(((bcfx)((bcgk)localObject3).a.get(i)).jdField_b_of_type_JavaLangString).append("::");
              }
              for (;;)
              {
                i += 1;
                break;
                ((StringBuilder)localObject5).append(((bcfx)((bcgk)localObject3).a.get(i)).jdField_b_of_type_JavaLangString);
              }
            }
          }
          bcjy.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((bbzy)localObject2).jdField_a_of_type_JavaLangString).ver2(bcjy.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + bcjy.jdField_b_of_type_JavaLangString + "}"));
        }
      }
    }
    label1809:
    if (bbzx.jdField_a_of_type_JavaUtilHashMap.containsKey(localbcfp))
    {
      localObject2 = (bbzy)bbzx.jdField_a_of_type_JavaUtilHashMap.get(localbcfp);
      if (!((bbzy)localObject2).jdField_a_of_type_Boolean)
      {
        if (bcni.a(((bbzy)localObject2).jdField_a_of_type_Long))
        {
          if (!((bbzy)localObject2).jdField_b_of_type_Boolean) {
            break label2889;
          }
          i = 2;
          label1863:
          bcni.a("all_result", "exp_object", i, 0, new String[] { ((bbzy)localObject2).jdField_a_of_type_JavaLangString, ((bbzy)localObject2).jdField_a_of_type_Long + "", ((bbzy)localObject2).jdField_b_of_type_JavaLangString, ((bbzy)localObject2).jdField_a_of_type_Int + "" });
          ((bbzy)localObject2).jdField_a_of_type_Boolean = true;
          bbzx.jdField_a_of_type_JavaUtilHashMap.put((bcfr)localbcfp, localObject2);
        }
        if ((localbcfp instanceof bcha))
        {
          localObject3 = (bcha)localbcfp;
          if ((((bcha)localObject3).jdField_a_of_type_Int == -3) || (((bcha)localObject3).jdField_a_of_type_Int == -4))
          {
            if (!((bbzy)localObject2).jdField_b_of_type_Boolean) {
              break label2895;
            }
            i = 2;
            label2015:
            bcni.a("all_result", "exp_net_search", i, 0, new String[] { ((bbzy)localObject2).jdField_a_of_type_JavaLangString, ((bbzy)localObject2).jdField_a_of_type_Long + "", ((bbzy)localObject2).jdField_b_of_type_JavaLangString, ((bbzy)localObject2).jdField_a_of_type_Int + "" });
          }
        }
      }
    }
    Object localObject2 = paramView;
    if (!a(paramView, localbcfp)) {
      localObject2 = null;
    }
    paramView = super.getView(paramInt, (View)localObject2, paramViewGroup);
    a(paramInt, paramView, localbcfp);
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
      bool2 = a(paramView, localbcfp, paramInt, i, j, bool2);
    }
    if ((paramView != null) && (paramView.findViewById(2131365649) != null))
    {
      if (!bool2) {
        break label2901;
      }
      paramView.findViewById(2131365649).setVisibility(8);
    }
    for (;;)
    {
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
        return paramView;
        label2272:
        if (((!(localbcfp instanceof bcga)) || ((localbcfp instanceof bcgo))) && (((!(localbcfp instanceof bcep)) && ((!(localbcfp instanceof bcha)) || (((bcha)localbcfp).jdField_a_of_type_Int != -4))) || (!bbzx.b.containsKey(localbcfp)))) {
          break;
        }
        localObject2 = (bbzy)bbzx.b.get(localbcfp);
        if ((localbcfp instanceof bcgl))
        {
          localObject3 = (bcgl)localbcfp;
          if (!((bbzy)localObject2).jdField_a_of_type_Boolean)
          {
            ((bbzy)localObject2).jdField_a_of_type_Boolean = true;
            localObject5 = new StringBuilder();
            if ((((bcgl)localObject3).a != null) && (((bcgl)localObject3).a.size() > 0))
            {
              i = 0;
              while (i < ((bcgl)localObject3).a.size())
              {
                ((StringBuilder)localObject5).append(((bcgw)((bcgl)localObject3).a.get(i)).jdField_a_of_type_JavaLangString).append("::");
                i += 1;
              }
              bcjy.a(null, new ReportModelDC02528().module("all_result").action("exp_relatedsearch_list").obj1("1007").ver1(((bbzy)localObject2).jdField_a_of_type_JavaLangString).ver2(bcjy.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + bcjy.jdField_b_of_type_JavaLangString + "}"));
            }
            bcjy.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((bbzy)localObject2).jdField_a_of_type_JavaLangString).ver2(bcjy.a(this.b)).ver5("2").ver7("{experiment_id:" + bcjy.jdField_b_of_type_JavaLangString + "}"));
          }
        }
        if (((bbzy)localObject2).jdField_a_of_type_Boolean) {
          break;
        }
        ((bbzy)localObject2).jdField_a_of_type_Boolean = true;
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("project", bcjy.a());
          ((JSONObject)localObject3).put("event_src", "client");
          ((JSONObject)localObject3).put("get_src", "web");
          ((JSONObject)localObject3).put("obj_lct", ((bbzy)localObject2).jdField_a_of_type_Int);
          if ((localbcfp instanceof bcga)) {
            ((JSONObject)localObject3).put("tepl", ((bcga)localbcfp).f);
          }
          localObject5 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          bcjy.a((QQAppInterface)localObject5, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((bbzy)localObject2).jdField_a_of_type_Long + "").obj2(((bbzy)localObject2).jdField_b_of_type_JavaLangString).ver1(((bbzy)localObject2).jdField_a_of_type_JavaLangString).ver2(bcjy.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject5).getCurrentAccountUin() + bbzx.jdField_a_of_type_Long));
        }
        catch (JSONException localJSONException3)
        {
          for (;;)
          {
            QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + localJSONException3);
          }
        }
      }
      label2889:
      i = 1;
      break label1863;
      label2895:
      i = 1;
      break label2015;
      label2901:
      paramView.findViewById(2131365649).setVisibility(0);
    }
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
      if ((localObject instanceof bcey))
      {
        localObject = (bcey)localObject;
        k = i + 1;
        ((bcey)localObject).a(1, k);
        i = j;
        if (((bcey)localObject).b() == 2) {
          i = j + 1;
        }
        ((bcey)localObject).a(3, i);
        ((bcey)localObject).a(0, k, i);
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
        if ((localObject instanceof bcgz))
        {
          localObject = (bcgz)localObject;
          k += 1;
          ((bcgz)localObject).a(k, i, j);
          m = i;
          i = k;
          k = j;
          j = m;
        }
        else
        {
          m = k;
          if ((localObject instanceof bcep))
          {
            localObject = (bcep)localObject;
            m = k + 1;
            ((bcep)localObject).a(m, i, j);
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
      QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "onDecodeTaskCompleted, remainingTasks : " + paramInt1 + ", type : " + paramInt2 + ", uin : " + paramString + ", avatar : " + paramBitmap + ", mFaceDecoder.isPausing() : " + this.jdField_a_of_type_Aoof.a() + ", mScrollState : " + this.jdField_a_of_type_Int);
    }
    if ((!this.jdField_a_of_type_Aoof.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1);
        bcfo localbcfo;
        bcik localbcik;
        bcnx localbcnx;
        if (((localView.getTag(2131381109) instanceof bcfo)) && ((localView.getTag(2131381111) instanceof bcik)) && ((localView.getTag(2131381115) instanceof bcnx)))
        {
          localbcfo = (bcfo)localView.getTag(2131381109);
          localbcik = (bcik)localView.getTag(2131381111);
          localbcnx = (bcnx)localView.getTag(2131381115);
          if ((localbcfo.c() == paramInt2) && (paramString.equals(localbcfo.b()))) {
            localbcik.a(localbcfo, localbcnx, paramBitmap);
          }
        }
        if ((localView instanceof ViewGroup))
        {
          int i = 0;
          while (i < ((ViewGroup)localView).getChildCount())
          {
            localbcfo = (bcfo)((ViewGroup)localView).getChildAt(i).getTag(2131381109);
            if ((localbcfo != null) && (localbcfo.c() == paramInt2) && (paramString.equals(localbcfo.b())))
            {
              localbcik = (bcik)((ViewGroup)localView).getChildAt(i).getTag(2131381111);
              localbcnx = (bcnx)((ViewGroup)localView).getChildAt(i).getTag(2131381115);
              if ((localbcik != null) && (localbcnx != null)) {
                localbcik.a(localbcfo, localbcnx, paramBitmap);
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
    if (this.jdField_a_of_type_Blih != null) {
      this.jdField_a_of_type_Blih.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    this.jdField_a_of_type_Bcks.a(paramInt1, paramInt2, paramInt3);
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
      if (this.jdField_a_of_type_Aoof.a()) {
        this.jdField_a_of_type_Aoof.b();
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
          bcfo localbcfo = (bcfo)((ViewGroup)localView).getChildAt(j).getTag(2131381109);
          bcik localbcik = (bcik)((ViewGroup)localView).getChildAt(j).getTag(2131381111);
          bcnx localbcnx = (bcnx)((ViewGroup)localView).getChildAt(j).getTag(2131381115);
          if ((localbcik != null) && (localbcfo != null) && (paramAbsListView != null)) {
            localbcik.a(localbcfo, localbcnx);
          }
          j += 1;
        }
      }
      i += 1;
      continue;
      this.jdField_a_of_type_Aoof.a();
      this.jdField_a_of_type_Aoof.c();
    }
    if (this.jdField_a_of_type_Blih != null) {
      this.jdField_a_of_type_Blih.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.jdField_a_of_type_Bcks.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbl
 * JD-Core Version:    0.7.0.1
 */