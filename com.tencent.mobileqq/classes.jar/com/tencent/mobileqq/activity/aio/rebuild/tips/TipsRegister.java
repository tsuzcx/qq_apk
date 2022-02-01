package com.tencent.mobileqq.activity.aio.rebuild.tips;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.IMsgTipsFilter;
import com.tencent.mobileqq.activity.aio.coreui.tips.IMsgTipsListener;
import java.util.ArrayList;
import java.util.List;

public class TipsRegister
{
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private volatile List<IMsgTipsFilter> jdField_a_of_type_JavaUtilList;
  private volatile List<IMsgTipsListener> b;
  
  public TipsRegister(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  private void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new FoldMsgTipsFilter());
        localArrayList.add(new MediaMsgTipsFilter());
        localArrayList.add(new KandianMsgTipsFilter());
        localArrayList.add(new NearbyTipsFilter());
        localArrayList.add(new ConfessTipsFilter());
        localArrayList.add(new GameMsgTipsFilter());
        localArrayList.add(new TroopMsgTipsFilter());
        localArrayList.add(new SpecialCareTipsFilter());
        localArrayList.add(new WeiShiTipsFilter());
        localArrayList.add(new TempMsgBoxTipsFilter());
        localArrayList.add(new CMRTipsFilter());
        localArrayList.add(new SubAccountTipsFilter());
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a == 1008) {
          localArrayList.add(new PATipsFilter());
        }
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(24));
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(39));
        localArrayList.add(new WatchTogetherTipsFilter());
        this.jdField_a_of_type_JavaUtilList = localArrayList;
      }
      return;
    }
    finally {}
  }
  
  private void b()
  {
    try
    {
      if (this.b == null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new SpecialCareTipsFilter());
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.i()) {
          localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(109));
        }
        localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(115));
        this.b = localArrayList;
      }
      return;
    }
    finally {}
  }
  
  public List<IMsgTipsFilter> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      a();
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<IMsgTipsListener> b()
  {
    if (this.b == null) {
      b();
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.tips.TipsRegister
 * JD-Core Version:    0.7.0.1
 */