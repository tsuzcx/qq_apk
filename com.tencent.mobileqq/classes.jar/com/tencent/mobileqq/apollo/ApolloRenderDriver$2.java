package com.tencent.mobileqq.apollo;

class ApolloRenderDriver$2
  extends IApolloRunnableTask
{
  ApolloRenderDriver$2(ApolloRenderDriver paramApolloRenderDriver) {}
  
  public String a()
  {
    return "startLoop";
  }
  
  public void run()
  {
    if (this.this$0.b > 0) {}
    for (String str = String.format("mainTicker.interval = %f;mainTicker.paused = false;renderTicker.paused = false;renderTicker.interval = %f;BK.Director.tickerResume();", new Object[] { Double.valueOf(60.0D / this.this$0.jdField_a_of_type_Int), Double.valueOf(60.0D / this.this$0.jdField_a_of_type_Int) });; str = String.format("var tickerIntervar = %d; if(BK.Director.ticker){BK.Director.ticker.interval = tickerIntervar; BK.Director.ticker.paused = false; } if (\"undefined\" != typeof renderTicker){renderTicker.interval = tickerIntervar; renderTicker.paused = false; } BK.Director.tickerSetInterval(tickerIntervar); if(BK.Director.tickerResume){BK.Director.tickerResume(); }", new Object[] { Integer.valueOf(60 / this.this$0.jdField_a_of_type_Int) }))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine.a(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRenderDriver.2
 * JD-Core Version:    0.7.0.1
 */