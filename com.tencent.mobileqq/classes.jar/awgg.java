public abstract class awgg
{
  private static final String CLOSE_EXCEPTION_MSG = "The EntityManagerFactory has been already closed";
  private boolean closed;
  private final ambz dbHelper = build(paramString);
  private String mName;
  
  public awgg(String paramString)
  {
    this.mName = paramString;
  }
  
  public abstract ambz build(String paramString);
  
  public void close()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    this.closed = true;
    this.dbHelper.a();
  }
  
  public awgf createEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    awgs localawgs = new awgs(this.dbHelper, this.mName);
    this.closed = false;
    return localawgs;
  }
  
  public awgf createMessageRecordEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    awgn localawgn = new awgn(this.dbHelper, this.mName);
    this.closed = false;
    return localawgn;
  }
  
  public boolean isOpen()
  {
    return !this.closed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awgg
 * JD-Core Version:    0.7.0.1
 */