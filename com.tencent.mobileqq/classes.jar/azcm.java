import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/TimePair;", "", "interval", "", "updateTimeSec", "(JJ)V", "getInterval", "()J", "setInterval", "(J)V", "getUpdateTimeSec", "setUpdateTimeSec", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class azcm
{
  private long a;
  private long b;
  
  public azcm()
  {
    this(0L, 0L, 3, null);
  }
  
  public azcm(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public final long a()
  {
    return this.a;
  }
  
  public final void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public final void b(long paramLong)
  {
    this.b = paramLong;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof azcm))
      {
        paramObject = (azcm)paramObject;
        if ((this.a != paramObject.a) || (this.b != paramObject.b)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = this.a;
    int i = (int)(l ^ l >>> 32);
    l = this.b;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    return "TimePair(interval=" + this.a + ", updateTimeSec=" + this.b + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azcm
 * JD-Core Version:    0.7.0.1
 */