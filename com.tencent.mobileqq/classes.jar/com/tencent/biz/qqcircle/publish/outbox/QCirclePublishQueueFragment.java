package com.tencent.biz.qqcircle.publish.outbox;

import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

public class QCirclePublishQueueFragment
  extends QCircleBaseFragment
{
  private List<Part> c;
  private QCirclePublishQueueTitlePart d;
  private QCirclePublishQueuePart e;
  private QCirclePublishQueueNetStateBannerPart f;
  
  public int a()
  {
    return -1;
  }
  
  public String b()
  {
    return "QCirclePublishQueueFragment";
  }
  
  protected int c()
  {
    return 2131626931;
  }
  
  protected List<Part> d()
  {
    if (this.c == null)
    {
      this.c = new ArrayList();
      this.d = new QCirclePublishQueueTitlePart();
      this.c.add(this.d);
      this.e = new QCirclePublishQueuePart();
      this.c.add(this.e);
      this.f = new QCirclePublishQueueNetStateBannerPart();
      this.c.add(this.f);
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.QCirclePublishQueueFragment
 * JD-Core Version:    0.7.0.1
 */