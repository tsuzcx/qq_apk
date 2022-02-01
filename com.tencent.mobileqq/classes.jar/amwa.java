import com.tencent.mobileqq.apollo.ApolloRenderDriver;

public abstract interface amwa
  extends amwx
{
  public abstract void bulkApolloBarrages(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract int getHeight();
  
  public abstract int getInitHeight();
  
  public abstract long getLuaState();
  
  public abstract amul getRenderImpl();
  
  public abstract int getWidth();
  
  public abstract ApolloRenderDriver getWorker();
  
  public abstract void removeAllApolloBarrages(boolean paramBoolean);
  
  public abstract void setBubbleType(int paramInt);
  
  public abstract void setVisibility(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwa
 * JD-Core Version:    0.7.0.1
 */