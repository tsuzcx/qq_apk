public abstract class auko
{
  private static final String CLOSE_EXCEPTION_MSG = "The EntityManagerFactory has been already closed";
  private boolean closed;
  private final akfv dbHelper = build(paramString);
  private String mName;
  
  public auko(String paramString)
  {
    this.mName = paramString;
  }
  
  public abstract akfv build(String paramString);
  
  public void close()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    this.closed = true;
    this.dbHelper.a();
  }
  
  public aukn createEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    aula localaula = new aula(this.dbHelper, this.mName);
    this.closed = false;
    return localaula;
  }
  
  public aukn createMessageRecordEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    aukv localaukv = new aukv(this.dbHelper, this.mName);
    this.closed = false;
    return localaukv;
  }
  
  public boolean isOpen()
  {
    return !this.closed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     auko
 * JD-Core Version:    0.7.0.1
 */