package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;

public class CmpCtxt
{
  public IReadInJoyModel a;
  public FeedItemCell.CellListener a;
  
  public static boolean a(IReadInJoyModel paramIReadInJoyModel)
  {
    return (paramIReadInJoyModel.a() == 49) || (paramIReadInJoyModel.a() == 62) || (paramIReadInJoyModel.a() == 63);
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    return UtilsForComponent.a(paramArticleInfo);
  }
  
  public static boolean b(IReadInJoyModel paramIReadInJoyModel)
  {
    return (paramIReadInJoyModel.a() == 39) || (paramIReadInJoyModel.a() == 116) || (paramIReadInJoyModel.a() == 66) || (paramIReadInJoyModel.a() == 115);
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    return UtilsForComponent.b(paramArticleInfo);
  }
  
  public static boolean c(IReadInJoyModel paramIReadInJoyModel)
  {
    switch (paramIReadInJoyModel.a())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean c(ArticleInfo paramArticleInfo)
  {
    int i = RIJItemViewType.a(paramArticleInfo);
    return (i == 23) || (i == 26) || (i == 56) || (i == 59);
  }
  
  public static boolean d(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.c() == 3;
  }
  
  public static boolean e(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.a() == 10;
  }
  
  public static boolean f(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.a() == 11;
  }
  
  public static boolean g(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.a() == 12;
  }
  
  public static boolean h(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.a() == 27;
  }
  
  public static boolean i(IReadInJoyModel paramIReadInJoyModel)
  {
    return paramIReadInJoyModel.a() == 28;
  }
  
  public static boolean j(IReadInJoyModel paramIReadInJoyModel)
  {
    return UtilsForComponent.b(paramIReadInJoyModel.a());
  }
  
  public static boolean k(IReadInJoyModel paramIReadInJoyModel)
  {
    return UtilsForComponent.a(paramIReadInJoyModel.a());
  }
  
  public int a()
  {
    if ((m()) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a() instanceof AdvertisementInfo))) {
      return AdvertisementInfo.getBigAppAdStyle((AdvertisementInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a());
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSocialFeedInfo.a != null)) {}
    try
    {
      long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mSocialFeedInfo.a.a;
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      return 0L;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public IReadInJoyModel a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel;
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel = paramIReadInJoyModel;
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener = paramCellListener;
  }
  
  public boolean a()
  {
    return d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel);
  }
  
  public boolean b()
  {
    return e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel);
  }
  
  public boolean c()
  {
    return f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel);
  }
  
  public boolean d()
  {
    return g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel);
  }
  
  public boolean e()
  {
    return h(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a() == 50) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a() == 51) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a() == 52);
  }
  
  public boolean g()
  {
    return i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel);
  }
  
  public boolean h()
  {
    return a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel);
  }
  
  public boolean i()
  {
    return j(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel);
  }
  
  public boolean j()
  {
    return k(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel);
  }
  
  public boolean k()
  {
    return c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel);
  }
  
  public boolean l()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a() == 16;
  }
  
  public boolean m()
  {
    return b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt
 * JD-Core Version:    0.7.0.1
 */