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

public class bbir
  extends bbio
  implements aobv, bkhe
{
  protected int a;
  private aobu jdField_a_of_type_Aobu;
  private bbrz jdField_a_of_type_Bbrz = new bbrz();
  private bkhe jdField_a_of_type_Bkhe;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  public int b = -1;
  
  public bbir(ListView paramListView, aobu paramaobu, bkhe parambkhe, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Aobu = paramaobu;
    paramaobu.a(this);
    paramListView.setOnScrollListener(this);
    this.jdField_a_of_type_Bkhe = parambkhe;
    this.b = paramInt;
  }
  
  private bbrr a(int paramInt)
  {
    bbmw localbbmw = a(paramInt);
    if (localbbmw == null) {
      return null;
    }
    if (!(localbbmw instanceof bbrr)) {
      return null;
    }
    return (bbrr)localbbmw;
  }
  
  private void a(int paramInt, View paramView, bbmw parambbmw)
  {
    if ((paramView == null) || (parambbmw == null)) {}
    for (;;)
    {
      return;
      if ((parambbmw instanceof bboe))
      {
        paramView = (bbvh)paramView.getTag(2131380935);
        if ((paramView instanceof bbrt)) {}
        for (paramView = ((bbrt)paramView).a(); paramView != null; paramView = null)
        {
          this.jdField_a_of_type_Bbrz.a(paramInt, paramView);
          return;
        }
      }
    }
  }
  
  private boolean a(View paramView, bbmw parambbmw)
  {
    if ((paramView == null) || (parambbmw == null)) {
      return false;
    }
    if ((parambbmw instanceof bboe))
    {
      bbvh localbbvh = (bbvh)paramView.getTag(2131380935);
      paramView = null;
      if ((localbbvh instanceof bbrt)) {
        paramView = ((bbrt)localbbvh).a();
      }
      if (paramView == null) {
        return false;
      }
      if ((((bboe)parambbmw).f() != paramView.c()) || (((bboe)parambbmw).h() != paramView.b())) {
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
  
  private boolean a(View paramView, bbmw parambbmw, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt2 == 59)
    {
      if (paramView == null) {
        break label203;
      }
      paramView = (bbvh)paramView.getTag(2131380935);
      if (!(paramView instanceof bbrt)) {
        break label71;
      }
      paramView = (bbrt)paramView;
    }
    for (;;)
    {
      if ((paramView != null) && ((paramView instanceof bbsd)))
      {
        if (paramInt1 != 0) {
          break label76;
        }
        ((bbsd)paramView).a(false);
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
            if ((!(localObject instanceof bbmf)) || (((bbmf)localObject).jdField_a_of_type_Boolean)) {
              break label197;
            }
          }
        }
      }
      label167:
      label197:
      for (Object localObject = ((bbmf)localObject).a().a();; localObject = null)
      {
        if ((parambbmw != null) && (localObject != null) && (((List)localObject).contains(parambbmw))) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          if (paramInt2 == 0) {
            break label167;
          }
          ((bbsd)paramView).a(false);
          break;
        }
        break;
        paramView = a(paramInt1 - 1);
        if ((!(paramView instanceof bbrp)) || (((bbrp)paramView).a() != 1)) {
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
    if ((a(paramInt) instanceof bblv)) {
      return ((bblv)a(paramInt)).b();
    }
    if ((a(paramInt) instanceof bblw)) {
      return ((bblw)a(paramInt)).d();
    }
    return 0;
  }
  
  protected bbps a(int paramInt)
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
      return new bbqm(this.jdField_a_of_type_Aobu);
    case 41: 
      return new bbpq(this.jdField_a_of_type_Aobu);
    case 3: 
      return new bbqi(this.jdField_a_of_type_Aobu, false);
    case 12: 
      return new bbqi(this.jdField_a_of_type_Aobu, true);
    case 57: 
      return new bbpm();
    case 0: 
      return new bbqn();
    case 49: 
      return new bbqg();
    case 15: 
      return new bbqn();
    case 2: 
    case 8: 
      return new bbqb(this.jdField_a_of_type_Aobu);
    case 9: 
      return new bbqk();
    case 14: 
      return new bbqk();
    case 10: 
      return new blki();
    case 11: 
      return new atid(this.jdField_a_of_type_Aobu);
    case 13: 
      return new bbpd(this.jdField_a_of_type_Aobu);
    case 56: 
      return new bbpt(this.jdField_a_of_type_Aobu);
    case 60: 
      return new bbpx(this.jdField_a_of_type_Aobu);
    case 16: 
      return new bbqm(this.jdField_a_of_type_Aobu);
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 31: 
    case 40: 
      return new bboz(this.jdField_a_of_type_Aobu, a(paramInt), this);
    case 29: 
    case 30: 
    case 36: 
      return new bbpn();
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
      return new bbqr(this.jdField_a_of_type_Aobu, this);
    case 46: 
      return new bbqc(this.jdField_a_of_type_Aobu);
    }
    return new bbqd(this.jdField_a_of_type_Aobu, this);
  }
  
  protected bbvh a(int paramInt, ViewGroup paramViewGroup)
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
      return new bbwv(paramViewGroup, 2131562830);
    case 41: 
      return new bbvd(paramViewGroup);
    case 3: 
      return new bbwr(paramViewGroup);
    case 12: 
      return new bbwp(paramViewGroup);
    case 57: 
      return new bbvb(paramViewGroup);
    case 0: 
    case 15: 
      localObject1 = a(paramInt);
      if (!(localObject1 instanceof bbmf)) {
        break;
      }
    }
    for (boolean bool1 = ((bbmf)localObject1).a();; bool1 = false)
    {
      if (paramInt != 0) {
        bool2 = true;
      }
      return new bbwt(paramViewGroup, bool2, bool1);
      return new bbwv(paramViewGroup, 2131559633);
      return new bbwq(paramViewGroup);
      return new bbws(paramViewGroup, 2131562850, 2130846027, -1);
      return new bbws(paramViewGroup, 2131562850, 2130846027, 12);
      return new bbww(paramViewGroup, 2131559833);
      return new bbuy(paramViewGroup, 2131562834);
      return new bbvi(paramViewGroup, 2131562836);
      return new bbvk(paramViewGroup, 2131562837);
      return new bbux(paramViewGroup, 2131562879);
      return new bbwv(paramViewGroup, 2131562831);
      return new bbwv(paramViewGroup, 2131562838);
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = a(paramInt);
      localObject2 = bbsb.a().a((QQAppInterface)localObject2, paramViewGroup.getContext(), (bbmw)localObject1);
      if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof bboe))) {
        ((bboe)localObject1).c(((bbrr)localObject2).b());
      }
      if (localObject2 == null) {
        return new bbvb(paramViewGroup);
      }
      return ((bbrr)localObject2).a();
      return new bbwo(paramViewGroup, a(paramInt));
      localObject1 = a(paramInt);
      if ((localObject1 instanceof bboh)) {
        return new bbwn(paramViewGroup, ((bboh)localObject1).d());
      }
      throw new RuntimeException("model type is TYPE_UNITE_ENTRANCE_SUB_ITEM_COMMON_TEXT, but model item is not instance SearchResultModelForEntrance.");
      localObject1 = a(paramInt);
      if ((localObject1 instanceof bbnh))
      {
        localObject1 = (bbnh)localObject1;
        switch (((bbnh)localObject1).d())
        {
        case 5: 
        case 10: 
        default: 
          throw new RuntimeException("NetSearchTemplateBaseItem.getLayoutId() is " + ((bbnh)localObject1).e() + " which is not supported!!!");
        case 2: 
          return new bbvl(paramViewGroup, ((bbnh)localObject1).e());
        case 3: 
          return new bbwh(paramViewGroup, ((bbnh)localObject1).e());
        case 4: 
          return new bbvm(paramViewGroup, ((bbnh)localObject1).e());
        case 7: 
          return new bbvt(paramViewGroup, ((bbnh)localObject1).e());
        case 6: 
          return new bbwg(paramViewGroup, ((bbnh)localObject1).e());
        case 8: 
          return new bbwe(paramViewGroup, ((bbnh)localObject1).e());
        case 9: 
          return new bbwd(paramViewGroup, ((bbnh)localObject1).e());
        case 11: 
          return new bbvq(paramViewGroup, ((bbnh)localObject1).e());
        case 12: 
          return new bbvo(paramViewGroup, ((bbnh)localObject1).e());
        case 13: 
          return new bbvr(paramViewGroup, ((bbnh)localObject1).e());
        case 14: 
          return new bbwf(paramViewGroup, ((bbnh)localObject1).e());
        case 15: 
          return new bbwb(paramViewGroup, ((bbnh)localObject1).e());
        case 16: 
          return new bbvw(paramViewGroup, ((bbnh)localObject1).e());
        case 17: 
          return new bbvy(paramViewGroup, ((bbnh)localObject1).e());
        }
        return new bbvv(paramViewGroup, ((bbnh)localObject1).e());
      }
      throw new RuntimeException("model type is TYPE_UNITE_TEMPLATE_NORMAL or TYPE_UNITE_TEMPLATE_NEWS, but model item is not instance NetSearchTemplateBaseItem.");
      return new bbww(paramViewGroup, 2131559634);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 12;
    if ((super.a(paramInt) instanceof bbmh)) {
      i = 41;
    }
    do
    {
      return i;
      if ((super.a(paramInt) instanceof bbml)) {
        return 3;
      }
    } while ((super.a(paramInt) instanceof bbkq));
    if (((super.a(paramInt) instanceof bbmf)) && (this.b != 12))
    {
      if (((bbmf)super.a(paramInt)).jdField_a_of_type_Boolean) {
        return 0;
      }
      return 57;
    }
    if (((super.a(paramInt) instanceof bbmf)) && (this.b == 12))
    {
      if (((bbmf)super.a(paramInt)).jdField_a_of_type_Boolean) {
        return 15;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof bbmg))
    {
      bbmg localbbmg = (bbmg)super.a(paramInt);
      if ((localbbmg != null) && (localbbmg.jdField_a_of_type_Boolean)) {
        return 49;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof bbmq)) {
      return 2;
    }
    if ((super.a(paramInt) instanceof bblz)) {
      return 5;
    }
    if ((super.a(paramInt) instanceof bbmm)) {
      return 56;
    }
    if ((super.a(paramInt) instanceof bbmd)) {
      return 6;
    }
    if ((super.a(paramInt) instanceof bbmo)) {
      return 60;
    }
    if ((super.a(paramInt) instanceof bbmb)) {
      return 8;
    }
    if ((super.a(paramInt) instanceof bblx)) {
      return 16;
    }
    if (((super.a(paramInt) instanceof bbmn)) && (this.b != 12)) {
      return 9;
    }
    if (((super.a(paramInt) instanceof bbmn)) && (this.b == 12)) {
      return 14;
    }
    if ((a(paramInt) instanceof blkm)) {
      return 10;
    }
    if ((a(paramInt) instanceof atig)) {
      return 11;
    }
    if (((super.a(paramInt) instanceof bbmi)) || ((super.a(paramInt) instanceof bbmk))) {
      return 13;
    }
    if ((a(paramInt) instanceof bbmp)) {
      return 17;
    }
    if ((a(paramInt) instanceof bbmj)) {
      return 19;
    }
    if ((a(paramInt) instanceof bboe)) {
      return 59;
    }
    if ((a(paramInt) instanceof bblw))
    {
      switch (((bblw)a(paramInt)).d())
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
    if ((a(paramInt) instanceof bboh))
    {
      switch (((bboh)a(paramInt)).jdField_a_of_type_Int)
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
    if ((a(paramInt) instanceof bbnh))
    {
      switch (((bbnh)a(paramInt)).d())
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
    if ((a(paramInt) instanceof bboc)) {
      return 46;
    }
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bbmw localbbmw = a(paramInt);
    Object localObject3;
    int j;
    int i;
    Object localObject6;
    Object localObject7;
    if (bbhd.a(localbbmw) > 0)
    {
      Object localObject1;
      if (bbhd.b.containsKey(localbbmw))
      {
        localObject1 = (bbhe)bbhd.b.get(localbbmw);
        if (!((bbhe)localObject1).jdField_a_of_type_Boolean)
        {
          ((bbhe)localObject1).jdField_a_of_type_Boolean = true;
          localObject3 = new JSONObject();
        }
      }
      try
      {
        ((JSONObject)localObject3).put("project", bbrf.a());
        ((JSONObject)localObject3).put("event_src", "client");
        ((JSONObject)localObject3).put("get_src", "native");
        ((JSONObject)localObject3).put("obj_lct", ((bbhe)localObject1).jdField_a_of_type_Int);
        localObject4 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        bbrf.a((QQAppInterface)localObject4, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((bbhe)localObject1).jdField_a_of_type_Long + "").obj2(((bbhe)localObject1).jdField_b_of_type_JavaLangString).ver1(((bbhe)localObject1).jdField_a_of_type_JavaLangString).ver2(bbrf.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject4).getCurrentAccountUin() + bbhd.jdField_a_of_type_Long));
        ((bbhe)localObject1).jdField_a_of_type_Boolean = true;
        bbhd.b.put(localbbmw, localObject1);
        if ((localbbmw instanceof bbmx))
        {
          localObject1 = (bbmx)localbbmw;
          localObject3 = ((bbmx)localObject1).a();
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            j = Math.min(((List)localObject3).size(), ((bbmx)localObject1).a());
            i = 0;
            if (i < j) {
              if (bbhd.b.containsKey(((List)localObject3).get(i)))
              {
                localObject4 = (bbhe)bbhd.b.get(((List)localObject3).get(i));
                if (!((bbhe)localObject4).jdField_a_of_type_Boolean)
                {
                  ((bbhe)localObject4).jdField_a_of_type_Boolean = true;
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
            ((JSONObject)localObject6).put("project", bbrf.a());
            ((JSONObject)localObject6).put("event_src", "client");
            ((JSONObject)localObject6).put("get_src", "native");
            ((JSONObject)localObject6).put("obj_lct", ((bbhe)localObject4).jdField_a_of_type_Int);
            if (!(((List)localObject3).get(i) instanceof bbnd)) {
              break label716;
            }
            localObject7 = (bbnd)((List)localObject3).get(i);
            if (!((bbnd)localObject7).c()) {
              break;
            }
            localObject1 = "1";
            ((bbhe)localObject4).jdField_b_of_type_JavaLangString = ((bbnd)localObject7).e();
            localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            bbrf.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((bbhe)localObject4).jdField_a_of_type_Long + "").obj2(((bbhe)localObject4).jdField_b_of_type_JavaLangString).ver1(((bbhe)localObject4).jdField_a_of_type_JavaLangString).ver2(bbrf.a(this.b)).ver3((String)localObject1).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + bbhd.jdField_a_of_type_Long));
            ((bbhe)localObject4).jdField_a_of_type_Boolean = true;
            bbhd.b.put(((List)localObject3).get(i), localObject4);
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
            bbrf.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("exp_item").obj1(localJSONException2.jdField_a_of_type_Long + "").obj2(localJSONException2.jdField_b_of_type_JavaLangString).ver1(localJSONException2.jdField_a_of_type_JavaLangString).ver2(bbrf.a(this.b)).ver7(((JSONObject)localObject6).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + bbhd.jdField_a_of_type_Long));
            localJSONException2.jdField_a_of_type_Boolean = true;
            bbhd.b.put(((List)localObject3).get(i), localJSONException2);
          }
        }
      }
    }
    Object localObject5;
    if ((localbbmw instanceof bblv))
    {
      localObject2 = (bblv)localbbmw;
      if ((((bblv)localObject2).a() != null) && (((bblv)localObject2).a().size() > 0))
      {
        i = 0;
        for (;;)
        {
          if (i >= ((bblv)localObject2).a().size()) {
            break label1809;
          }
          localObject3 = (bbmw)((bblv)localObject2).a().get(i);
          if (bbhd.b.containsKey(localObject3))
          {
            localObject3 = (bbhe)bbhd.b.get(localObject3);
            if (!((bbhe)localObject3).jdField_a_of_type_Boolean)
            {
              ((bbhe)localObject3).jdField_a_of_type_Boolean = true;
              localObject5 = new JSONObject();
            }
          }
          try
          {
            ((JSONObject)localObject5).put("project", bbrf.a());
            ((JSONObject)localObject5).put("event_src", "client");
            ((JSONObject)localObject5).put("get_src", "web");
            ((JSONObject)localObject5).put("obj_lct", ((bbhe)localObject3).jdField_a_of_type_Int);
            localObject6 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            bbrf.a((QQAppInterface)localObject6, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((bbhe)localObject3).jdField_a_of_type_Long + "").obj2(((bbhe)localObject3).jdField_b_of_type_JavaLangString).ver1(((bbhe)localObject3).jdField_a_of_type_JavaLangString).ver2(bbrf.a(this.b)).ver7(((JSONObject)localObject5).toString()).session_id(((QQAppInterface)localObject6).getCurrentAccountUin() + bbhd.jdField_a_of_type_Long));
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
    else if ((localbbmw instanceof bbno))
    {
      localObject2 = ((bbno)localbbmw).a;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1809;
          }
          localObject3 = (bbnn)((Iterator)localObject2).next();
          if (bbhd.b.containsKey(localObject3))
          {
            localObject5 = (bbhe)bbhd.b.get(localObject3);
            if (!((bbhe)localObject5).jdField_a_of_type_Boolean)
            {
              ((bbhe)localObject5).jdField_a_of_type_Boolean = true;
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("project", bbrf.a());
                localJSONObject.put("event_src", "client");
                localJSONObject.put("get_src", "web");
                localJSONObject.put("obj_lct", ((bbhe)localObject5).jdField_a_of_type_Int);
                localJSONObject.put("extra_info", ((bbnn)localObject3).jdField_b_of_type_JavaLangString);
                localJSONObject.put("tepl", ((bbnn)localObject3).f);
                localObject7 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                bbrf.a((QQAppInterface)localObject7, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((bbnn)localObject3).jdField_a_of_type_Long + "").obj2(((bbnn)localObject3).j).ver1(((bbhe)localObject5).jdField_a_of_type_JavaLangString).ver2(bbrf.a(this.b)).ver7(localJSONObject.toString()).session_id(((QQAppInterface)localObject7).getCurrentAccountUin() + bbhd.jdField_a_of_type_Long));
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
      if (!(localbbmw instanceof bbnr)) {
        break label2272;
      }
      if (bbhd.b.containsKey(localbbmw))
      {
        localObject2 = (bbhe)bbhd.b.get(localbbmw);
        localObject3 = (bbnr)localbbmw;
        if (!((bbhe)localObject2).jdField_a_of_type_Boolean)
        {
          ((bbhe)localObject2).jdField_a_of_type_Boolean = true;
          localObject5 = new StringBuilder();
          if ((((bbnr)localObject3).a != null) && (((bbnr)localObject3).a.size() > 0))
          {
            i = 0;
            if (i < ((bbnr)localObject3).a.size())
            {
              if (i != ((bbnr)localObject3).a.size() - 1) {
                ((StringBuilder)localObject5).append(((bbne)((bbnr)localObject3).a.get(i)).jdField_b_of_type_JavaLangString).append("::");
              }
              for (;;)
              {
                i += 1;
                break;
                ((StringBuilder)localObject5).append(((bbne)((bbnr)localObject3).a.get(i)).jdField_b_of_type_JavaLangString);
              }
            }
          }
          bbrf.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((bbhe)localObject2).jdField_a_of_type_JavaLangString).ver2(bbrf.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + bbrf.jdField_b_of_type_JavaLangString + "}"));
        }
      }
    }
    label1809:
    if (bbhd.jdField_a_of_type_JavaUtilHashMap.containsKey(localbbmw))
    {
      localObject2 = (bbhe)bbhd.jdField_a_of_type_JavaUtilHashMap.get(localbbmw);
      if (!((bbhe)localObject2).jdField_a_of_type_Boolean)
      {
        if (bbup.a(((bbhe)localObject2).jdField_a_of_type_Long))
        {
          if (!((bbhe)localObject2).jdField_b_of_type_Boolean) {
            break label2889;
          }
          i = 2;
          label1863:
          bbup.a("all_result", "exp_object", i, 0, new String[] { ((bbhe)localObject2).jdField_a_of_type_JavaLangString, ((bbhe)localObject2).jdField_a_of_type_Long + "", ((bbhe)localObject2).jdField_b_of_type_JavaLangString, ((bbhe)localObject2).jdField_a_of_type_Int + "" });
          ((bbhe)localObject2).jdField_a_of_type_Boolean = true;
          bbhd.jdField_a_of_type_JavaUtilHashMap.put((bbmy)localbbmw, localObject2);
        }
        if ((localbbmw instanceof bboh))
        {
          localObject3 = (bboh)localbbmw;
          if ((((bboh)localObject3).jdField_a_of_type_Int == -3) || (((bboh)localObject3).jdField_a_of_type_Int == -4))
          {
            if (!((bbhe)localObject2).jdField_b_of_type_Boolean) {
              break label2895;
            }
            i = 2;
            label2015:
            bbup.a("all_result", "exp_net_search", i, 0, new String[] { ((bbhe)localObject2).jdField_a_of_type_JavaLangString, ((bbhe)localObject2).jdField_a_of_type_Long + "", ((bbhe)localObject2).jdField_b_of_type_JavaLangString, ((bbhe)localObject2).jdField_a_of_type_Int + "" });
          }
        }
      }
    }
    Object localObject2 = paramView;
    if (!a(paramView, localbbmw)) {
      localObject2 = null;
    }
    paramView = super.getView(paramInt, (View)localObject2, paramViewGroup);
    a(paramInt, paramView, localbbmw);
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
      bool2 = a(paramView, localbbmw, paramInt, i, j, bool2);
    }
    if ((paramView != null) && (paramView.findViewById(2131365606) != null))
    {
      if (!bool2) {
        break label2901;
      }
      paramView.findViewById(2131365606).setVisibility(8);
    }
    for (;;)
    {
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
        return paramView;
        label2272:
        if (((!(localbbmw instanceof bbnh)) || ((localbbmw instanceof bbnv))) && (((!(localbbmw instanceof bblw)) && ((!(localbbmw instanceof bboh)) || (((bboh)localbbmw).jdField_a_of_type_Int != -4))) || (!bbhd.b.containsKey(localbbmw)))) {
          break;
        }
        localObject2 = (bbhe)bbhd.b.get(localbbmw);
        if ((localbbmw instanceof bbns))
        {
          localObject3 = (bbns)localbbmw;
          if (!((bbhe)localObject2).jdField_a_of_type_Boolean)
          {
            ((bbhe)localObject2).jdField_a_of_type_Boolean = true;
            localObject5 = new StringBuilder();
            if ((((bbns)localObject3).a != null) && (((bbns)localObject3).a.size() > 0))
            {
              i = 0;
              while (i < ((bbns)localObject3).a.size())
              {
                ((StringBuilder)localObject5).append(((bbod)((bbns)localObject3).a.get(i)).jdField_a_of_type_JavaLangString).append("::");
                i += 1;
              }
              bbrf.a(null, new ReportModelDC02528().module("all_result").action("exp_relatedsearch_list").obj1("1007").ver1(((bbhe)localObject2).jdField_a_of_type_JavaLangString).ver2(bbrf.a(this.b)).ver4(((StringBuilder)localObject5).toString()).ver5("1").ver7("{experiment_id:" + bbrf.jdField_b_of_type_JavaLangString + "}"));
            }
            bbrf.a(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(((bbhe)localObject2).jdField_a_of_type_JavaLangString).ver2(bbrf.a(this.b)).ver5("2").ver7("{experiment_id:" + bbrf.jdField_b_of_type_JavaLangString + "}"));
          }
        }
        if (((bbhe)localObject2).jdField_a_of_type_Boolean) {
          break;
        }
        ((bbhe)localObject2).jdField_a_of_type_Boolean = true;
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("project", bbrf.a());
          ((JSONObject)localObject3).put("event_src", "client");
          ((JSONObject)localObject3).put("get_src", "web");
          ((JSONObject)localObject3).put("obj_lct", ((bbhe)localObject2).jdField_a_of_type_Int);
          if ((localbbmw instanceof bbnh)) {
            ((JSONObject)localObject3).put("tepl", ((bbnh)localbbmw).f);
          }
          localObject5 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          bbrf.a((QQAppInterface)localObject5, new ReportModelDC02528().module("all_result").action("exp_item").obj1(((bbhe)localObject2).jdField_a_of_type_Long + "").obj2(((bbhe)localObject2).jdField_b_of_type_JavaLangString).ver1(((bbhe)localObject2).jdField_a_of_type_JavaLangString).ver2(bbrf.a(this.b)).ver7(((JSONObject)localObject3).toString()).session_id(((QQAppInterface)localObject5).getCurrentAccountUin() + bbhd.jdField_a_of_type_Long));
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
      paramView.findViewById(2131365606).setVisibility(0);
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
      if ((localObject instanceof bbmf))
      {
        localObject = (bbmf)localObject;
        k = i + 1;
        ((bbmf)localObject).a(1, k);
        i = j;
        if (((bbmf)localObject).b() == 2) {
          i = j + 1;
        }
        ((bbmf)localObject).a(3, i);
        ((bbmf)localObject).a(0, k, i);
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
        if ((localObject instanceof bbog))
        {
          localObject = (bbog)localObject;
          k += 1;
          ((bbog)localObject).a(k, i, j);
          m = i;
          i = k;
          k = j;
          j = m;
        }
        else
        {
          m = k;
          if ((localObject instanceof bblw))
          {
            localObject = (bblw)localObject;
            m = k + 1;
            ((bblw)localObject).a(m, i, j);
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
      QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "onDecodeTaskCompleted, remainingTasks : " + paramInt1 + ", type : " + paramInt2 + ", uin : " + paramString + ", avatar : " + paramBitmap + ", mFaceDecoder.isPausing() : " + this.jdField_a_of_type_Aobu.a() + ", mScrollState : " + this.jdField_a_of_type_Int);
    }
    if ((!this.jdField_a_of_type_Aobu.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1);
        bbmv localbbmv;
        bbpr localbbpr;
        bbve localbbve;
        if (((localView.getTag(2131380929) instanceof bbmv)) && ((localView.getTag(2131380931) instanceof bbpr)) && ((localView.getTag(2131380935) instanceof bbve)))
        {
          localbbmv = (bbmv)localView.getTag(2131380929);
          localbbpr = (bbpr)localView.getTag(2131380931);
          localbbve = (bbve)localView.getTag(2131380935);
          if ((localbbmv.c() == paramInt2) && (paramString.equals(localbbmv.b()))) {
            localbbpr.a(localbbmv, localbbve, paramBitmap);
          }
        }
        if ((localView instanceof ViewGroup))
        {
          int i = 0;
          while (i < ((ViewGroup)localView).getChildCount())
          {
            localbbmv = (bbmv)((ViewGroup)localView).getChildAt(i).getTag(2131380929);
            if ((localbbmv != null) && (localbbmv.c() == paramInt2) && (paramString.equals(localbbmv.b())))
            {
              localbbpr = (bbpr)((ViewGroup)localView).getChildAt(i).getTag(2131380931);
              localbbve = (bbve)((ViewGroup)localView).getChildAt(i).getTag(2131380935);
              if ((localbbpr != null) && (localbbve != null)) {
                localbbpr.a(localbbmv, localbbve, paramBitmap);
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
    if (this.jdField_a_of_type_Bkhe != null) {
      this.jdField_a_of_type_Bkhe.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    this.jdField_a_of_type_Bbrz.a(paramInt1, paramInt2, paramInt3);
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
      if (this.jdField_a_of_type_Aobu.a()) {
        this.jdField_a_of_type_Aobu.b();
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
          bbmv localbbmv = (bbmv)((ViewGroup)localView).getChildAt(j).getTag(2131380929);
          bbpr localbbpr = (bbpr)((ViewGroup)localView).getChildAt(j).getTag(2131380931);
          bbve localbbve = (bbve)((ViewGroup)localView).getChildAt(j).getTag(2131380935);
          if ((localbbpr != null) && (localbbmv != null) && (paramAbsListView != null)) {
            localbbpr.a(localbbmv, localbbve);
          }
          j += 1;
        }
      }
      i += 1;
      continue;
      this.jdField_a_of_type_Aobu.a();
      this.jdField_a_of_type_Aobu.c();
    }
    if (this.jdField_a_of_type_Bkhe != null) {
      this.jdField_a_of_type_Bkhe.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.jdField_a_of_type_Bbrz.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbir
 * JD-Core Version:    0.7.0.1
 */