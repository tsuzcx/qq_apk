public abstract class aukq
{
  private static final String CLOSE_EXCEPTION_MSG = "The EntityManagerFactory has been already closed";
  private boolean closed;
  private final akfu dbHelper = build(paramString);
  private String mName;
  
  public aukq(String paramString)
  {
    this.mName = paramString;
  }
  
  public abstract akfu build(String paramString);
  
  public void close()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    this.closed = true;
    this.dbHelper.a();
  }
  
  public aukp createEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    aulc localaulc = new aulc(this.dbHelper, this.mName);
    this.closed = false;
    return localaulc;
  }
  
  public aukp createMessageRecordEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    aukx localaukx = new aukx(this.dbHelper, this.mName);
    this.closed = false;
    return localaukx;
  }
  
  public boolean isOpen()
  {
    return !this.closed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukq
 * JD-Core Version:    0.7.0.1
 */