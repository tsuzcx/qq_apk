package com.tencent.biz.pubaccount.readinjoy.proteus.data;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import org.json.JSONObject;

public class ProteusItemDataBuilder
{
  JSONObject a = new JSONObject();
  
  public ProteusItemDataBuilder A(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.S(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder B(BaseArticleInfo paramBaseArticleInfo)
  {
    return this;
  }
  
  public ProteusItemDataBuilder C(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.a(this.a, paramBaseArticleInfo);
    return this;
  }
  
  public ProteusItemDataBuilder D(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.U(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder E(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mChannelID == 0L)) {
      return this;
    }
    Util.a(this.a);
    return this;
  }
  
  public ProteusItemDataBuilder F(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.y(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder G(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.V(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder H(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.W(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder I(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.Y(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder J(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.Z(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder K(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.aa(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder L(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.X(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder M(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.C(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder N(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.E(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder O(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.Q(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder P(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.ag(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder Q(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.am(paramBaseArticleInfo, this.a);
    Util.ah(paramBaseArticleInfo, this.a);
    Util.ai(paramBaseArticleInfo, this.a);
    Util.aj(paramBaseArticleInfo, this.a);
    Util.ak(paramBaseArticleInfo, this.a);
    Util.al(paramBaseArticleInfo, this.a);
    Util.ao(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder a(BaseArticleInfo paramBaseArticleInfo)
  {
    J(paramBaseArticleInfo);
    K(paramBaseArticleInfo);
    return this;
  }
  
  public ProteusItemDataBuilder a(BaseArticleInfo paramBaseArticleInfo, long paramLong)
  {
    Util.a(paramBaseArticleInfo, this.a, Long.valueOf(paramLong));
    return this;
  }
  
  public ProteusItemDataBuilder a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    Util.b(paramBaseArticleInfo, this.a, paramString);
    return this;
  }
  
  public ProteusItemDataBuilder a(String paramString)
  {
    this.a.put("style_ID", paramString);
    return this;
  }
  
  public ProteusItemDataBuilder a(String paramString, Object paramObject)
  {
    this.a.put(paramString, paramObject);
    return this;
  }
  
  public JSONObject a()
  {
    return this.a;
  }
  
  public ProteusItemDataBuilder b(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.r(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder b(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    Util.a(paramBaseArticleInfo, this.a, paramString);
    return this;
  }
  
  public ProteusItemDataBuilder c(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.A(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder c(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    Util.c(paramBaseArticleInfo, this.a, paramString);
    return this;
  }
  
  public ProteusItemDataBuilder d(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.s(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder d(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    Util.d(paramBaseArticleInfo, this.a, paramString);
    return this;
  }
  
  public ProteusItemDataBuilder e(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.t(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder f(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.u(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder g(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.v(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder h(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.w(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder i(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.T(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder j(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.a(paramBaseArticleInfo, this.a, "id_dislike_button");
    return this;
  }
  
  public ProteusItemDataBuilder k(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.l(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder l(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.m(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder m(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.L(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder n(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.J(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder o(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.M(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder p(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.N(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder q(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.K(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder r(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.n(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder s(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.o(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder t(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.p(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder u(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.q(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder v(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.G(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder w(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.I(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder x(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.O(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder y(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.P(paramBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder z(BaseArticleInfo paramBaseArticleInfo)
  {
    Util.R(paramBaseArticleInfo, this.a);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.data.ProteusItemDataBuilder
 * JD-Core Version:    0.7.0.1
 */